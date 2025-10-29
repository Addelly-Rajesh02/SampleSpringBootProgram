package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.EmployeeEntity;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByFirstName(String firstname);

    List<EmployeeEntity> findByDepartmentAndJobTitle(String department, String jobTitle);

    boolean existsByEmail(String email);
}
