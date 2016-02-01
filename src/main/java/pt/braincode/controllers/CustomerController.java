package pt.braincode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.braincode.domain.Customer;
import pt.braincode.services.CustomerService;

import java.util.List;

/**
 * Created by sletras on 01/02/2016.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public String getAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @RequestMapping(value="/customers/{customerId}", method = RequestMethod.GET)
    public String getCustomerById(@PathVariable Integer customerId, Model model){
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "customer";
    }

    @RequestMapping(value="/customers", method = RequestMethod.POST)
    public String createCustomer(@RequestBody Customer customer){
        customerService.createNewCustomer(customer);

        return "redirect:/customers";
    }

    @RequestMapping("/customer")
    public String customerPage(Model model){
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @RequestMapping(value="/customers/{customerId}", method = RequestMethod.PUT)
    public String updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerId){
        customerService.updateCustomer(customer, customerId);
        return "redirect:/customers";
    }

    @RequestMapping(value="/customers/{customerId}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }
}
