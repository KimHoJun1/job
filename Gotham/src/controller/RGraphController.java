package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rtest.RChart;
import rtest.RGraph;
import rtest.WordCloud2;
@Controller
public class RGraphController {
	@Autowired
	RGraph rg;
	@Autowired
	RChart rc;
	@Autowired
	WordCloud2 wc;
		
	@RequestMapping("/graph1")
	public ModelAndView get1() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("img_content", rg.returnRImg1());
		mav.setViewName("rgraph");
		return mav;
	}	
	@RequestMapping("/graph2")
	public ModelAndView get2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("img_content", rg.returnRImg2());
		mav.setViewName("rgraph");
		return mav;
	}		
	@RequestMapping("/wordcloud1")
	public ModelAndView get3() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("img_content", rg.returnRImg3());
		mav.setViewName("rgraph");
		return mav;
	}
	@RequestMapping("/rchart")
	public ModelAndView get4(String data) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rchart_content", rc.returnRChart(data));
		mav.setViewName("interactive");
		return mav;
	}
	@RequestMapping("/wordcloud2")
	public ModelAndView get5() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rchart_content", wc.returnWC2());
		mav.setViewName("interactive");
		return mav;
	}	
	@RequestMapping("/leaflet")
	public ModelAndView get6() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rchart_content", rc.returnLeaflet());
		mav.setViewName("interactive");
		return mav;
	}	

}






