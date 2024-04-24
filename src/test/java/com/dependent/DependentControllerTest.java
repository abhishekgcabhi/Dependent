package com.dependent;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dependent.controller.DependentController;
import com.dependent.model.DependentModel;
import com.dependent.service.DependentService;

@WebMvcTest(DependentController.class)
public class DependentControllerTest {

	@MockBean
	DependentService dependentService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void test_getByEmpId() throws Exception {
		Long empId = 20L;
		List<DependentModel> list = Arrays.asList(new DependentModel(1L, empId, "Jimmy", "Father", Date.valueOf("2002-09-09")),
				new DependentModel(1L, empId, "John", "Brother", Date.valueOf("2002-09-09")),
				new DependentModel(1L, empId, "Mary", "Mother", Date.valueOf("2002-09-09")));
		when(dependentService.getDependentByEmpId(empId)).thenReturn(list);
		mockMvc.perform(get("/dependents/getDependents/{empId}", empId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$[1].name").value("John"));
	}
	
}
