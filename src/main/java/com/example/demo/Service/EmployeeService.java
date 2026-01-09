package com.example.demo.Service;

import com.example.demo.Entity.EmployeeEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity addEmployee(@Valid EmployeeEntity employee);

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity updateEmployee(Long id, EmployeeEntity newEmployeeEntity);

    Boolean deleteEmployee(Long id);

    EmployeeEntity getEmployeeById(Long id);

    List<EmployeeEntity> all(String department, String jobTitle);

    Page<EmployeeEntity> getProducts(int pageNo, int pageSize);
}
