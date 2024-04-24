package com.dependent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dependent.model.DependentModel;
import com.dependent.repository.DependentRepository;

@Service
public class DependentServiceImpl implements DependentService {
	
	@Autowired
	private DependentRepository dependentRepository;

	/**
	 * Add the dependents of the employee
	 * @param dependentModel
	 * @return
	 */
	@Override
	public DependentModel addDependent(DependentModel dependentModel) {
		// TODO Auto-generated method stub
		return dependentRepository.save(dependentModel);
	}

	/**
	 * Fetch all the dependents of specific employee
	 * @param empId - Id of an Employee
	 * @return
	 */
	@Override
	public List<DependentModel> getDependentByEmpId(Long empId) {
		// TODO Auto-generated method stub
		List<DependentModel> dependent = dependentRepository.findByEmpId(empId);
		return dependent;
	}

}
