package com.spring.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.controller")
@EnableWebSecurity
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/saybye")
	public String bye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Bye %s!", name);
	}

	@GetMapping("/getPerson")
	public Person returnObject(@RequestParam(value = "name", defaultValue = "World") String name) {
		Person p = new Person(0, "Arsim", "Kosumi", 25);
		return p;
	}

	@GetMapping("/getPersonsList")
	public List<Person> returnPersons() {
		List<Person> persons = new ArrayList<>();

		Person p = new Person(0, "Arsim", "Kosumi", 25);
		Person p1 = new Person(1, "Filan", "Fisteku", 23);
		Person p2 = new Person(2, "Filane", "Fisteku", 24);

		persons.add(p);
		persons.add(p1);
		persons.add(p2);

		return persons;
	}

//	@PostMapping(value = "/addPerson")
//	public ResponseEntity<?> newPerson(@RequestParam("name") String name){
//	    return new ResponseEntity<>(new Person(3,name,"Fisteku",25), HttpStatus.OK);
//	}
//	
//	@PostMapping(path = "/users", 
//			consumes = MediaType.APPLICATION_JSON_VALUE, 
//	        produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> addUser(@RequestParam("name") String name){
//	    return new ResponseEntity<>(new Person(3,name,"Fisteku",25), HttpStatus.OK);
//	}

	@PostMapping("/user")
	public ResponseEntity<?> createPerson(@Validated @RequestBody Person person) {
		if(person.getEmri().equals("Arsim")) {
			return new ResponseEntity<>("Useri veq ekziston!", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}
