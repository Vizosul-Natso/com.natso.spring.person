package com.natso.spring.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.natso.spring.person.entity.Person;
import com.natso.spring.person.service.PersonService;

@Controller
public class ControllerClass {
	
	@Autowired
	private PersonService service ;
	
//	@RequestMapping(value = "home", method = RequestMethod.GET)
//	public ModelAndView homePage(ModelAndView mav) {
//		mav.setViewName("index");
//		return mav ;
//	}
	
	@RequestMapping(value = "createPerson", method = RequestMethod.GET)
	public ModelAndView createPerson(ModelAndView mav, Person person) {
		mav.addObject("person", person) ;
		mav.setViewName("form");
		return mav ;
	}

	
	@RequestMapping(value = "savePerson", method = RequestMethod.POST)
	public ModelAndView savePerson(ModelAndView mav, @ModelAttribute Person person) {
		service.savePerson(person);
		mav.setViewName("index");
		return mav ;
	}
	
	@RequestMapping(value = "findPerson", method = RequestMethod.GET)
	public ModelAndView findPerson(ModelAndView mav) {
		mav.setViewName("find");
		return mav ;
	}
	
	@RequestMapping(value = "findingPerson", method = RequestMethod.GET)
		public ModelAndView findingPerson(ModelAndView mav, HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id") ) ;
			Person obj = service.findPerson(id) ;
			mav.addObject("person", obj) ;
			mav.setViewName("showperson"); 
			return mav ;
	}
	
	@RequestMapping(value = "deletePerson", method = RequestMethod.GET)
		public ModelAndView deletePerson(ModelAndView mav) {
		mav.setViewName("deleteperson");
		return mav ;
	}
	
	@RequestMapping(value = "deletingperson", method = RequestMethod.GET)
		public ModelAndView deletingPerson(ModelAndView mav, HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id") ) ;
		     boolean flag = service.deletPerson(id) ;
		     
		     if (flag) {
				mav.addObject("msg", "Deletd Successfully...!") ;
				mav.setViewName("index");
				return mav ;
			}
		     else {
		    	 mav.addObject("msg", "Unable to Delete Person") ;
				 mav.setViewName("index");
				return mav ;
		     }
	 }
	
	@RequestMapping(value = "updatePerson", method = RequestMethod.GET)
	public ModelAndView updatePerson(ModelAndView mav) {
		mav.setViewName("updateperson");
		return mav ;
	}
	
	@RequestMapping(value = "updatingPerson", method = RequestMethod.GET)
	public ModelAndView updatingPerson(ModelAndView mav, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id") ) ;
		Person person = service.findPerson(id) ;
		mav.addObject("updateperson", person) ;
		mav.setViewName("updatingPerson");
		return mav ;
	}
	
	@RequestMapping(value = "saveUpdatePerson", method = RequestMethod.POST)
	public ModelAndView savingUpdatedPerson(ModelAndView mav, @ModelAttribute Person jeevith) {
		
		service.updatePerson(jeevith);
		mav.setViewName("index");
		return mav ;
	}
	
	@RequestMapping(value = "displayAll", method =  RequestMethod.GET)
	public ModelAndView displayAll(ModelAndView mav) {
		
		List<Person> list = service.displayAll() ;
		
		System.out.println(list);
		
		for(Person p : list) {
			System.out.println(p);
		}
		
		
		mav.setViewName("index");
		return mav ;
	}
	
//    @Autowired
//    private PersonService personService;
//
//    @GetMapping("/displayAll")
//    public String getAllPersons(Model model) {
//        List<Person> persons = personService.displayAll();
//        model.addAttribute("persons", persons);
//        return "findall"; //
//    }
//	

}