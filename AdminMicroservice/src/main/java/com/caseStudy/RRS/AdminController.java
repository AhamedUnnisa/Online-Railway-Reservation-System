package com.caseStudy.RRS;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

 

@RestController
public class AdminController {

	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Admin train) {
		repository.save(train);
		return "Added book with id : " + train.getTrainid();
	}

	@GetMapping("/getAllTrains")
	public List<Admin> gettrains() {
		return repository.findAll();
	}
	
	
	@GetMapping("/search")
	public List<Object> Search() {
	Object[] objects = restTemplate.getForObject("http://TrainSearchMicroService/findAllTrains", Object[].class);
	return Arrays.asList(objects);
	}
	
	

	@GetMapping("/getAllTrains/{trainid}")
	public Optional<Admin> getTrain(@PathVariable String trainid) {
		return repository.findById(trainid);
	}

	@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) {
		repository.deleteById(trainid);
		return "Train deleted with id : "+trainid;
	
	}
	
	@PutMapping("/update/{trainid}")
	public Admin updateTrain(@PathVariable("trainid") String trainid,@RequestBody Admin t ) {
		t.setTrainid(trainid);
		repository.save(t);
		return t;
}
}