package com.example.demo.Service.Impl;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Exception.EmailAlreadyExistsException;
import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.Exception.EntityNotFoundException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employee){
        try {
            if(employeeRepository.existsByEmail(employee.getEmail())){
                throw new EmailAlreadyExistsException("Email Id already exists");
            }
            return employeeRepository.save(employee);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Please enter data");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmployeeEntity> getAllEmployees(){
        try {
            return employeeRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Data not found with id"+id));
        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity newEmployeeEntity) {
        EmployeeEntity existingEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));

        if (newEmployeeEntity.getFirstName() != null) {
            existingEntity.setFirstName(newEmployeeEntity.getFirstName());
        }
        if (newEmployeeEntity.getLastName() != null) {
            existingEntity.setLastName(newEmployeeEntity.getLastName());
        }
        if (newEmployeeEntity.getEmail() != null) {
            existingEntity.setEmail(newEmployeeEntity.getEmail());
        }
        if (newEmployeeEntity.getDepartment() != null) {
            existingEntity.setDepartment(newEmployeeEntity.getDepartment());
        }
        if (newEmployeeEntity.getJobTitle() != null) {
            existingEntity.setJobTitle(newEmployeeEntity.getJobTitle());
        }
        if (newEmployeeEntity.getSalary() != null) {
            existingEntity.setSalary(newEmployeeEntity.getSalary());
        }

        return employeeRepository.save(existingEntity);
    }

    @Override
    public Boolean deleteEmployee(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeEntity> all(String department, String jobTitle){
        return employeeRepository.findByDepartmentAndJobTitle(department,jobTitle);
    }

    @Override
    public Page<EmployeeEntity> getProducts(int pageNo, int pageSize) {
        // Page numbers are 0-based in Spring Data JPA
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return employeeRepository.findAll(pageable);
    }

}
