package com.example.demo.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.dto.ServerResponse;

@RestController
@RequestMapping(value="/emps")
public class EmployeeRestController {

	private List<Employee> employees = new ArrayList<Employee>();

	@PostConstruct
	public void init() {
		employees.add(new Employee(1, "Adam", "Sandler"));
		employees.add(new Employee(2, "Bob", "Ross"));
		employees.add(new Employee(3, "Chris", "Evans"));
	}

	//@GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public Object get() {
		ServerResponse message = new ServerResponse(employees);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}

	@PostMapping
	public Object post(@RequestBody Employee employee) {

		if (employees.size() > 0) {
			Comparator<Employee> comp = (e1, e2) -> Integer.compare(e1.getId(), e2.getId());

			Employee emp = employees.stream().max(comp).get();
			
			// employess의 최대 키 값을 찾아서 (최대 키 값 + 1) 해서 넣는다.
			employee.setId(emp.getId() + 1);
		} else {
			employee.setId(1);
		}
		employees.add(employee);
		
		ServerResponse message = new ServerResponse(employee);
		message.setMessage("정상처리되었습니다.");
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		Employee emp = employees.stream()
				.filter((e) -> e.getId() == id)
				.findAny().orElse(null);
		if (emp != null) {
			employees.remove(emp);
		}

		//return new ResponseEntity(HttpStatus.OK); // 200 OK만 응답한다.
		
		/*
		 * 아래와 같이 응답한다. 
		 * {
			"status": "Success",
			"message": null,
			"data": null,
			"errorCode": null,
			"errorMessage": null
			}
		 */
		ServerResponse message = new ServerResponse();
		message.setMessage("정상처리되었습니다.");
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Object update(@PathVariable int id, 
			@RequestBody Employee employee) {
		Employee emp = employees.stream()
				.filter((e) -> e.getId() == id)
				.findAny().orElse(null);
		if (emp != null) {
			employees.set(employees.indexOf(emp), employee);
		}
		
		ServerResponse message = new ServerResponse(employee);
		message.setMessage("정상처리되었습니다.");
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
}