package com.caseStudy.RRS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AdminMicroServiceApplicationTests {
@Mock
private TrainRepository repository;
@Autowired
private TrainController control;
@Test
void contextLoads() {
}

@Test
public void addTrain(){
Train train = new Train ("2", "Note",
"hyd","delhi");
when((repository).insert(train)).thenReturn(train);
assertEquals(train, (repository).insert(train)); }

/*@Test
public void getTrain(){
when(repository.findAll()).thenReturn(Stream.of(new Train("2","Note","hyd","delhi")).collect(Collectors.toList()));
assertEquals(1,control.getBooks().size());
} */


}

