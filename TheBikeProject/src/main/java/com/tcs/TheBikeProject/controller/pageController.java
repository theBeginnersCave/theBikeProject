package com.tcs.TheBikeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.Bikebackend.dao.CatagoryDAO;
import com.tcs.Bikebackend.dto.Catagory;

@Controller
public class pageController {
	
    @Autowired
    private CatagoryDAO catagoryDAO;
    
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");	mv.addObject("catagories", catagoryDAO.list());
	
		mv.addObject("userClickHome", true);
		return mv;
	}
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting" ,required=false)String greeting)
	{
		if(greeting == null)
		{
			greeting="hello";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	/* methods to load all the products and based on catagory */
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");	mv.addObject("catagories", catagoryDAO.list());
	
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/catagory/{id}/products")
	public ModelAndView showCatagoryProducts(@PathVariable("id")int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		Catagory catagory=null;
		catagory=catagoryDAO.get(id);
		
		mv.addObject("title", catagory.getName());
		
		mv.addObject("catagories", catagoryDAO.list());
		
		/* Passing single catagory object */
		
		mv.addObject("catagory", catagory);
	
		mv.addObject("userClickCatagoryProducts", true);
		return mv;
	}
}




