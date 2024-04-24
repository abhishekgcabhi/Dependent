package com.dependent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependent.model.DependentModel;
import com.dependent.service.DependentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/dependents")
public class DependentController {
	
	@Autowired
	private DependentService dependentService;
	
	@PostMapping("/addDependents")
	public ResponseEntity<?> addDependent(@RequestBody DependentModel dependentModel) {
		DependentModel dependent = dependentService.addDependent(dependentModel);
		if(dependent!=null) {
			return ResponseEntity.ok(dependent);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dependents Not Added");
		}
	}
	
	@GetMapping("/getDependents/{empId}")
	public ResponseEntity<?> getByEmpId(@PathVariable Long empId){
		List<DependentModel> dependent = dependentService.getDependentByEmpId(empId);
		if(dependent!=null) {
			return ResponseEntity.ok(dependent);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("empId not exist");
		}
	}

}
