package rtest;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;

@Service
public class Infection {
	public String returnInfec() {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("require(Kormaps)");
			r.eval("rm(list=ls())");
			r.eval("library(webshot)");
			r.eval("require(tmap)");
			r.eval("require(leaflet)");
			r.eval("library(data.table)");
			r.eval("library(dplyr)");
			r.eval("inf <- fread('C:/Rstudy/Rgotham/Report3.csv', sep=',/', header = T, stringsAsFactors = F)");
			r.eval("inf[1:25,1:9]");

//			korpopmap1@data$name
//			r.eval("Encoding(names(korpopmap1))<-'UTF-8'");
//			r.eval("Encoding(korpopmap1@data$name)<-'UTF-8'");
//			r.eval("Encoding(korpopmap1@data$행정구역별_읍면동)<-'UTF-8'");

			r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$행정구역별_읍면동)<-'UTF-8'");
//			korpopmap2@data$name

//			Encoding(names(korpopmap3))<-"UTF-8"
//			Encoding(korpopmap3@data$name)<-"UTF-8"
//			Encoding(korpopmap3@data$행정구역별_읍면동)<-"UTF-8"
//			korpopmap3@data$name

			r.eval("korpopmap2@data <- korpopmap2@data[-26:-251,]");

			r.eval("korpopmap2@data <- cbind(korpopmap2@data, inf)");
			r.eval("korpopmap2@polygons <- korpopmap2@polygons[-26:-251]");


			r.eval("mymap <- korpopmap2@data");
			r.eval("mypalette <- colorNumeric(palette = 'Reds', domain = mymap$A형간염)");
			r.eval("mypopup <- paste0(mymap$name,' A형간염 발생 수 : ',mymap$A형간염)");

			r.eval("seoulmap <- leaflet(korpopmap2) %>% addTiles() %>% addPolygons(stroke = FALSE,"
					+ "smoothFactor = 0.2,fillOpacity = .8,popup = mypopup,color = ~mypalette(mymap$A형간염))");
			r.eval("seoulmap %>% setView(lat=37.559957, lng=126.975302, zoom=11)");


//			r.eval("url <- 'https://weather.com/ko-KR/weather/today/l/"+lat+","+lng+"'");
//			r.eval("text <- read_html(url, encoding='UTF-8')");
//			r.eval("nodes <- html_nodes(text,'div > div.today_nowcard-temp > span')");
//			r.eval("result <- html_text(nodes,trim=TRUE)");
//			r.eval("result <- substr(result,1,length(result))");
			return r.eval("seoulmap").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
/*	
	public String returnComm(double lat, double lng) {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(rvest)");
			r.eval("url <- 'https://weather.com/ko-KR/weather/today/l/"+lat+","+lng+"'");
			r.eval("text <- read_html(url, encoding='UTF-8')");
			r.eval("nodes <- html_nodes(text,'div > section div.today_nowcard-phrase')");
			r.eval("result2 <- html_text(nodes,trim=TRUE)");
			System.out.println(r.eval("result2").asString());
			return r.eval("result2").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}*/
}

/*devtools::install_github("cardiomoon/Kormaps")
require(Kormaps)

rm(list=ls())
library(webshot)
# install.packages("webshot")
require(Kormaps)
require(tmap)
require(leaflet)
library(data.table)
library(dplyr)
inf <- fread("C:/Rstudy/Rgotham/Report3.csv", sep=",", header = T, stringsAsFactors = F)
inf[1:25,1:9]

korpopmap1@data$name
Encoding(names(korpopmap1))<-"UTF-8"
Encoding(korpopmap1@data$name)<-"UTF-8"
Encoding(korpopmap1@data$행정구역별_읍면동)<-"UTF-8"

Encoding(names(korpopmap2))<-"UTF-8"
Encoding(korpopmap2@data$name)<-"UTF-8"
Encoding(korpopmap2@data$행정구역별_읍면동)<-"UTF-8"
korpopmap2@data$name

Encoding(names(korpopmap3))<-"UTF-8"
Encoding(korpopmap3@data$name)<-"UTF-8"
Encoding(korpopmap3@data$행정구역별_읍면동)<-"UTF-8"
korpopmap3@data$name

colnames(inf)
inf_gu <- inf %>% select(자치구)
# length(inf_gu)
# dim(korpopmap2@data)
# head(korpopmap2@data,251)
# length(korpopmap2@data$name)

# korpopmap2@data[26:251,]<-NA

korpopmap2@data <- korpopmap2@data[-26:-251,]


View(korpopmap2@polygons)


# imsi <- matrix(NA, ncol = 9, nrow = 255)
# imsi1 <- as.data.frame(imsi)
# colnames(imsi1) <- c("자치구","A형간염", "유행성이하선염", "B형간염", "수두", "결핵", "성홍열", "쯔쯔가무시증", "합계")
# 
# inf1 <- rbind(inf, imsi1)
# str(imsi1)
# View(inf)
# inf <- inf1[1:251,]

korpopmap2@data <- cbind(korpopmap2@data, inf)
korpopmap2@polygons <- korpopmap2@polygons[-26:-251]


mymap <- korpopmap2@data
mypalette <- colorNumeric(palette = "Reds", domain = mymap$A형간염)
mypopup <- paste0(mymap$name," A형간염 발생 수 : ",mymap$A형간염)

seoulmap <- leaflet(korpopmap2) %>% addTiles() %>% addPolygons(stroke = FALSE,
                                                   smoothFactor = 0.2,
                                                   fillOpacity = .8,
                                                   popup = mypopup,
                                                   color = ~mypalette(mymap$A형간염))
seoulmap %>% setView(lat=37.559957, lng=126.975302, zoom=11)


*/