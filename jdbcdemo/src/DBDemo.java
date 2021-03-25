import java.time.LocalDate;
import java.util.List;

import com.cg.jdbcdemo.dto.Employee;
import com.cg.jdbcdemo.service.EmployeeService;

public class DBDemo {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		
		System.out.println(employeeService.insertEmployee(105, "Tony", 1000, LocalDate.of(21,2,28)));
		
		//System.out.println(employeeService.modifyEmployee(104, "Rama", 5000));
		
		//System.out.println(employeeService.deleteEmployee(103));
		
		//System.out.println(employeeService.deleteEmployee(110));
		
		//Employee e1 = employeeService.getEmployee(102);
		//if(e1!=null)
			//System.out.println(e1.getEmpid()+"  "+e1.getEname()+"  "+e1.getSalary()+"  "+e1.getDoj());
		List<Employee> elist = employeeService.getAllEmployees();
		for (Employee e: elist) {
			System.out.println(e.getEmpid()+"  "+e.getEname()+"  "+e.getSalary()+"  "+e.getDoj());
		}
	}

}
