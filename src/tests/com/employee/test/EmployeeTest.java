
package com.employee.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.dao.EmployeeMapper;
import com.employee.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = { EmployeeMapper.class })
public class EmployeeTest {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Test
	public void allCrudEmp() { // create operation

		Employee emp = new Employee();
		emp.setCompanyName("Infosys");
		emp.setDesignation("Developer");
		emp.setDob("26-05-1994");
		emp.setEmpName("Raje");
		emp.setSal(45632.15f);
		System.out.println("Values executing");

		assertEquals("values inserted Successfully", 0, employeeMapper.saveEmployee(emp));
		Employee emps = new Employee();
		emps.setCompanyName("HCL");
		emps.setDesignation("Tech Lead");
		emps.setDob("26-03-1984");
		emps.setEmpName("suku");
		emps.setSal(45692.15f);
		assertEquals("values inserted Successfully", 0, employeeMapper.saveEmployee(emps)); // update operation

		Employee empn = employeeMapper.getEmployee(emp.getEmpId());

		empn.setEmpName("Rahul");

		assertEquals("Values Updated Successfully", 0, employeeMapper.updateEmployee(empn));

		// Delete Operation

		assertEquals("Value Deleted Successfully", 0, employeeMapper.deleteEmployee(26));

		// Read All

		List<Employee> lim = employeeMapper.getAllEmployees();
		assertEquals("All Values fetched Successfully", lim, lim);

	}
}
