package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EmployeeData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentRollNumber")
    private Long id;

    @Column(name = "First Name")
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "First name must contain only alphabets and single spaces")
    private String firstName;

    @Column(name = "Last Name")
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Last name must contain only alphabets and single spaces")
    private String lastName;

    @Column(name = "Email", unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "Branch")
    @NotBlank(message = "Department is required")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Department must contain only alphabets and single spaces")
    private String department;

    @Column(name = "Job Title")
    @NotBlank(message = "Job Title is required")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Job Title must contain only alphabets and single spaces")
    private String jobTitle;

    @Column(name = "Salary")
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;

}
