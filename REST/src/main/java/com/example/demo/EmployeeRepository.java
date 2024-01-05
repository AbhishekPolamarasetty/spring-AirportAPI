package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
//Employee - it is the entity type that this repository manages
// Long - type of primary key of the entity