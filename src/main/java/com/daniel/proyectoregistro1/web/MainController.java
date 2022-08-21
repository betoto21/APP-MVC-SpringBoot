package com.daniel.proyectoregistro1.web;

import com.daniel.proyectoregistro1.dao.IContractDAO;
import com.daniel.proyectoregistro1.dao.IContractTypeDAO;
import com.daniel.proyectoregistro1.domain.Contract;
import com.daniel.proyectoregistro1.domain.Employee;
import com.daniel.proyectoregistro1.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IContractDAO contractDAO;
    @Autowired
    private IContractTypeDAO contractTypeDAO;

    @GetMapping("/")
    public String init(Model model){
        List<Employee> employees = employeeService.listEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee1", new Employee());
        log.info("executing index");
        return "index";
    }

    @GetMapping("/addemployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        log.info("executing addemployee");
        return "addemployee";
    }

    @PostMapping("/editemployee")
    public String editEmployee(Model model, Employee employee){
        Employee employee1 = employeeService.searchEmployee(employee);
        model.addAttribute("employee", employee1);
        log.info("executing editemployee");
        return "editemployee";
    }

    @PostMapping("/saveemployee")
    public String saveEmployee(Model model, Employee employee){
        employeeService.saveEmployee(employee);
        log.info("executing saveemployee");
        return "redirect:/";
    }

    @GetMapping("/addcontract")
    public String addContract(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractstypes", contractTypeDAO.findAll());
        log.info("executing addcontract");
        return "addcontract";
    }

    @PostMapping("/savecontract")
    public String saveContract(Model model, Contract contract){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        String date = dateFormat.format(now);
        contract.setDate_created(date);
        contractDAO.save(contract);
        log.info("executing savecontract");
        return "redirect:/";
    }

    @PostMapping("/deleteemployee")
    public String deleteEmployee(Employee employee, Model model){
        employeeService.deleteEmployee(employee);
        log.info("deleting employee");
        return "redirect:/";
    }
}
