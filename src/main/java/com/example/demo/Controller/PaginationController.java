package com.example.demo.Controller;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaginationController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeEntity>> getProducts(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<EmployeeEntity> productsPage = employeeService.getProducts(pageNo, pageSize);
        return ResponseEntity.ok(productsPage);
    }

}
