package com.fastpix.EmployeeDemoApplication.repositories;

import com.fastpix.EmployeeDemoApplication.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
