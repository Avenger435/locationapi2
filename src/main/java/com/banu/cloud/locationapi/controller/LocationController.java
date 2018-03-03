package com.banu.cloud.locationapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banu.cloud.locationapi.model.Location;
import com.banu.cloud.locationapi.repository.LocationRepository;

@RestController
@RequestMapping("/api")
public class LocationController {

	@Autowired
	LocationRepository locationRepository;

	@GetMapping("/all")
	public List<Location> getAll() {

		return locationRepository.findAll();
	}

	@GetMapping("/location/{city}")
	public ResponseEntity<List<Location>> findByCityIgnoreCase(@PathVariable(value = "city") String city) {
		System.out.println("Inside the findByCityIgnoreCase ");
		List<Location> location1 = (List<Location>) locationRepository.findByCityIgnoreCase(city);
		return ResponseEntity.ok().body(location1);
	}
}
