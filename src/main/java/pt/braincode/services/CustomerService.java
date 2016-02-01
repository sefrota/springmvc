package pt.braincode.services;

import pt.braincode.domain.Customer;

import java.util.List;

/**
 * Created by sletras on 01/02/2016.
 */
public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    void createNewCustomer(Customer customer);

    void updateCustomer(Customer customer, Integer id);

    void deleteCustomer(Integer id);

}
