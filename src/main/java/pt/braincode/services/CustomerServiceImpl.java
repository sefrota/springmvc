package pt.braincode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.braincode.domain.Customer;
import pt.braincode.repositories.CustomerRepo;

import java.util.List;

/**
 * Created by sletras on 01/02/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public List<Customer> getAllCustomers() {
        return repo.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repo.getCustomerById(id);
    }

    @Override
    public void createNewCustomer(Customer customer) {
        repo.createNewCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer, Integer id) {
        repo.updateCustomer(customer, id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        repo.deleteCustomer(id);
    }
}
