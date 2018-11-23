package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rtest.Infection;
import rtest.Weather;

@Controller
public class MainController {	
	@Autowired
	Weather wt;
	@Autowired
	Infection inf;
	
	@RequestMapping("/main")
	public ModelAndView getWeather(double lat, double lng) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("temp", wt.returnTemp(lat, lng));
		mav.addObject("comm", wt.returnComm(lat, lng));
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/inf")
	public ModelAndView getInfection() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("infec", inf.returnInfec());
		mav.setViewName("inftest");
		return mav;
	}
}
