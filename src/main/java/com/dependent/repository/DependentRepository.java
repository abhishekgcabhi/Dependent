package com.dependent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dependent.model.DependentModel;

public interface DependentRepository extends JpaRepository<DependentModel,Long> {

	List<DependentModel> findByEmpId(Long empId);

}
