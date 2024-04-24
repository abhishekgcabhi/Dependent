package com.dependent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dependent.model.DependentModel;


@Service
public interface DependentService {

	DependentModel addDependent(DependentModel dependentModel);
	
	List<DependentModel> getDependentByEmpId(Long empId);
	
}
