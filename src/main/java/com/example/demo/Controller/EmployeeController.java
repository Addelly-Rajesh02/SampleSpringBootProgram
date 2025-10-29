package com.example.demo.Controller;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.GreetingService;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@Valid @RequestBody EmployeeEntity employee){
        EmployeeEntity employeeEntity=employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        List<EmployeeEntity> allEmployees=employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        EmployeeEntity employeeEntity=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity newEmployeeEntity){
        EmployeeEntity updatedEntity=employeeService.updateEmployee(id, newEmployeeEntity);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        Boolean value=employeeService.deleteEmployee(id);
        if(value) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }
        else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByDepartmentAndJobTitle")
    public ResponseEntity<List<EmployeeEntity>> all(@RequestParam String department, @RequestParam String jobTitle){
        List<EmployeeEntity> employee=employeeService.all(department,jobTitle);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
