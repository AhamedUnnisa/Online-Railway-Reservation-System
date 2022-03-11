package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminMicroserviceApplicationTests {

	
	void contextLoads() {
	}
}
	/*
	@Test
	@DisplayName("adding")
	public void saveTrainTest() {
		Trains train = new Trains("877","Sonarpur Local","Sealdah","Sonarpur");
		when(trainsrepository.save(train)).thenReturn(train);
		assertEquals(train, trainservice.addTrain(train));

		}
	@Test
	@DisplayName("delete")
	public void deleteUserTest() {
		Trains train = new Trains("12","Howrah local","Bandel","Howrah");
		trainservice.deleteTrain(train);
		verify(trainsrepository, times(1)).delete(train);
	}
	
	@Test 
	@DisplayName("Alltrains")
	public void getTrainTest() {
		  when(trainsrepository.findAll()).thenReturn(Stream
				  .of(new Trains("1","Mysore Express","Mysore","Bangalore"),
            	 new  Trains("12","Jagannath Express","Mumbai","Puri"),
            	 new Trains("3","Malgudi Express","Mysore","Pondicherry")).collect(Collectors.toList()));
		  assertEquals(3,trainservice.getContact().size()); }
	
}
*/



