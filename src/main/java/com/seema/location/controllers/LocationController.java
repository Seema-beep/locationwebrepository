package com.seema.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seema.location.entities.Location;
import com.seema.location.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
    
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap)

	{   Location locationSaved = service.saveLocation(location);
	    String msg="Location saved with id:"+locationSaved.getId();
	    modelMap.addAttribute("msg", msg);//modelMap is used when response is sent back
		return "createLocation";
		
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	
	
}
