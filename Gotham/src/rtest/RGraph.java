package rtest;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;
@Service
public class RGraph {
	public byte[] returnRImg1() {
		RConnection r = null;
		byte retImg [] = null;
		try {
			r = new RConnection();		
			r.eval("jpeg('test.jpg')");
			r.eval("x <- 1:10");
			r.eval("barplot(x, names='SALES', col=rainbow(15))");
			r.eval("dev.off()");
			r.eval("r<-readBin('test.jpg','raw',1024*1024)");
			//r.eval("unlink('test.jpg')");
			retImg = r.eval("r").asBytes();
		} catch(Exception e) {
			System.out.println(e);	
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retImg; 
	}
	public byte[] returnRImg2() {
		RConnection r = null;
		byte retImg [] = null;
		try {
			r = new RConnection();		
			r.eval("library(DBI)");
			r.eval("library(rJava)"); 
			r.eval("setwd('c:/RStudy/exam1')");
			r.eval("result <- read.table('product_click.log')");
			r.eval("names(result) <- c('CLICK_TIME', 'PID')");
			r.eval("data_p <- table(result$PID)");
			r.eval("data_t <- table(substr(result$CLICK_TIME,9,10)) ");
			r.eval("jpeg('test.jpg')");
			r.eval("par(mfrow=c(1,2))");
			r.eval("pie(data_p, radius = 1, col=rainbow(10))");
			r.eval("barplot(data_t, col=terrain.colors(10))");
			r.eval("dev.off()");
			r.eval("r=readBin('test.jpg','raw',1020*1020)");
			r.eval("unlink('test.jpg')");
			retImg = r.eval("r").asBytes();
		} catch(Exception e) {
			System.out.println(e);	
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retImg; 
	}
	
	public byte[] returnRImg3() {
		RConnection r = null;
		byte retImg [] = null;
		try {
			r = new RConnection();	
			r.eval("jpeg('test.jpg')");
			r.eval("library(rJava)");
			r.eval("library(KoNLP)");
			r.eval("library(XML)");
			r.eval("library(stringr)");
			r.eval("library(wordcloud)");			
			r.eval("t <- htmlTreeParse('http://hankookilbo.com', useInternalNodes=TRUE, trim=TRUE)");
			r.eval("content<- xpathSApply(t,'//p', xmlValue)");
			r.eval("useSejongDic()");
			r.eval("word <- sapply(content,extractNoun,USE.NAMES=F)");
			r.eval("cdata <- unlist(word)");
			r.eval("cdata <- str_replace_all(cdata,'[^[가-힣]]','');"+
					  "cdata <- str_replace_all(cdata,'한국일보닷컴','');"+
					  "cdata <- str_replace_all(cdata,'한국일보','');"+
					  "cdata <- str_replace_all(cdata,'보기','')");
			r.eval("cdata <- Filter(function(x) {nchar(x) >= 2} ,cdata)");
			r.eval("wordcount <- table(cdata)");
			r.eval("wordcount <- head(sort(wordcount, decreasing=T),20)");
			r.eval("wordcloud(names(wordcount),freq=wordcount,scale=c(4,1),"+
					  "rot.per=0.35,min.freq=2,random.order=F,random.color=T,colors=rainbow(20))");
			r.eval("dev.off()");
			r.eval("r=readBin('test.jpg','raw',1020*1020)");
			r.eval("unlink('test.jpg')");
			retImg = r.eval("r").asBytes();			
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();			
		}
		return retImg;
	}	
}
