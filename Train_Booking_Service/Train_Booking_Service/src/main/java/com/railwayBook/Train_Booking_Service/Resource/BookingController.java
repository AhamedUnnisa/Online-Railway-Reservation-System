package com.railwayBook.Train_Booking_Service.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//import com.caseStudy.RRS.Train;
import com.railwayBook.Train_Booking_Service.Repository.BookTrainRepository;
import com.railwayBook.Train_Booking_Service.jwtmodels.AuthenticationRequest;
import com.railwayBook.Train_Booking_Service.jwtmodels.AuthenticationResponse;
import com.railwayBook.Train_Booking_Service.jwtutil.JwtUtil;
import com.railwayBook.Train_Booking_Service.models.BookTrain;
import com.railwayBook.Train_Booking_Service.securityconfigure.MyUserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@RestController("/book")

@RestController(value = "/book")
@Api( tags = "Books")
public class BookingController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;

	
	
	@Autowired
	private BookTrainRepository bookRepository;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@ApiOperation(value = "This method is used to get the book.")
	
	@GetMapping("/findAllTickets")
	public List<BookTrain> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/findAllTrains")
	public List<Object> getStudents() {
	Object[] objects = restTemplate.getForObject("http://TrainSearchMicroService/findAllTrains", Object[].class);
	return Arrays.asList(objects);
	}
	
	@GetMapping("/findAllTickets/{train_id}")
	public Optional<BookTrain> getBooks(@PathVariable String train_id) {
		return bookRepository.findById(train_id);
	}
	

	/*@GetMapping("/{id}")
	public Optional<BookTrain> getTicket(@PathVariable int id){
		return bookRepository.findById(id);
	}*/
	
	
	@PostMapping("/addTicket")
	public String saveTicket(@RequestBody BookTrain book) {
		bookRepository.save(book);
		return "Added Ticket with id:"+book.getTrain_id();
	}
	
	@PutMapping("/update/{id}")
	public BookTrain updateTicket(@PathVariable("id") String id,@RequestBody BookTrain Ticket ) {
		Ticket.setTrain_id(id);
	    bookRepository.save(Ticket);
		return Ticket;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteTicket(@PathVariable String id) {
		bookRepository.deleteById(id);
		return "Ticket deleted by id:"+id;
	}
	
	
	@RequestMapping(value= "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
	try {
	authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}catch (BadCredentialsException e) {
	throw new Exception("Incorrect username or password",e);
	}
	final UserDetails userDetails=userDetailsService
	.loadUserByUsername(authenticationRequest.getUsername());
	final String jwt=jwtTokenUtil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}
	

}
