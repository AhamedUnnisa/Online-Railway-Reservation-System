package com.caseStudy.RRS;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@CrossOrigin(origins="http://localhost:4200")
@RestController
//@RequestMapping("api/")
public class TrainController {

	@Autowired
	private TrainRepository repository;

	@PostMapping("/addTrain")
	public String saveBook(@RequestBody Train train) {
		repository.save(train);
		return "Added book with id : " + train.getTrainid();
	}

	@GetMapping("/findAllTrains")
	public List<Train> getBooks() {
		return repository.findAll();
	}

	@GetMapping("/findAllTrains/{trainid}")
	public Optional<Train> getBook(@PathVariable String trainid) {
		return repository.findById(trainid);
	}

	/*@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) {
		repository.deleteById(trainid);
		return "Train deleted with id : "+trainid;
	
	}*/
	
	/*@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train t ) {
		t.setTrainid(trainid);
		repository.save(t);
		return t;
}*/

}