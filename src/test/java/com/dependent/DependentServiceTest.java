package com.dependent;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dependent.model.DependentModel;
import com.dependent.repository.DependentRepository;
import com.dependent.service.DependentService;

@SpringBootTest
public class DependentServiceTest {
	
	@MockBean
	DependentRepository dependentRepository;
	
	@Autowired
	DependentService dependentService;
	
	@Test
	public void test_getDependentByEmpId() {
		Long empId = 20L;
		List<DependentModel> list = Arrays.asList(
				new DependentModel(1L, empId, "John", "Father", Date.valueOf("2002-09-09")),
				new DependentModel(2L, empId, "Cena", "Brother", Date.valueOf("2002-09-09")));
		when(dependentRepository.findByEmpId(empId)).thenReturn(list);
		List<DependentModel> dependent = dependentService.getDependentByEmpId(empId);
		assertEquals(2,dependent.size());
	}



}
