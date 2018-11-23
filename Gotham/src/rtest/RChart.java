package rtest;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;
@Service
public class RChart {
	public String returnRChart(String value)  {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(rCharts)");
			r.eval("product<-data.frame(apple=c(" + value + "))");
			r.eval("gg<-nPlot(~apple, data=product, type='pieChart', width='400', height='300')");
			r.eval(" out<- capture.output(gg$show('inline'));");
			r.eval("str  <- ''");
			r.eval(" for(i in 1:length(out)){ str<-paste(str, out[i], '\n'); }");
			return r.eval("str").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
	public String returnLeaflet()  {
		System.out.println("ㅎㅎ");
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(rCharts)");
			r.eval("map4 <- Leaflet$new()");
			r.eval("map4$setView(c(37.501290, 127.039564), zoom = 13)");
			r.eval("map4$marker(c(37.501290, 127.039564), bindPopup = '<p> 여기야... 여기 우리가 있는 곳!!</p>')");
			r.eval("out <- capture.output(map4$show('inline'))");
			r.eval("str  <- ''");
			r.eval(" for(i in 1:length(out)){ str<-paste(str, out[i], '\n'); }");
			return r.eval("str").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
}
