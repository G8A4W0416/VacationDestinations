package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Trip;
import dmacc.repository.TripRepository;

@Controller
public class WebController {
	@Autowired
	TripRepository repo;
	
	@GetMapping("/inputDestination")
	public String addNewDestination(Model model) {
	 Trip dest = new Trip();
	 model.addAttribute("newDestination", dest);
	 return "input";
	}
	
	@PostMapping("/inputDestination")
	public String addNewDestination(@ModelAttribute Trip dest, Model model) {
		repo.save(dest);
		return viewAllDestinations(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateDestination(@PathVariable("id") long id, Model model) {
		Trip dest = repo.findById(id).orElse(null);
		model.addAttribute("newDestination", dest);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseDestination(Trip dest, Model model) {
		repo.save(dest);
		return viewAllDestinations(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDestination(@PathVariable("id") long id, Model model) {
		Trip dest = repo.findById(id).orElse(null);
		repo.delete(dest);
		return viewAllDestinations(model);
	}
	
	@GetMapping({ "/", "viewAll" })
	public String viewAllDestinations(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewDestination(model);
		}
		model.addAttribute("destinations", repo.findAll());
		return "results";
	}
}
