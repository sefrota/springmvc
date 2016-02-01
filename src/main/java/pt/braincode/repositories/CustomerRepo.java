package pt.braincode.repositories;

import org.springframework.stereotype.Repository;
import pt.braincode.domain.Customer;

import java.util.*;

/**
 * Created by sletras on 01/02/2016.
 */
@Repository
public class CustomerRepo {

    private Map<Integer, Customer> customerDb;

    public CustomerRepo() {
            customerDb = new HashMap<Integer, Customer>();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<Customer>(customerDb.values());
    }

    public Customer getCustomerById(int id) {
        return customerDb.get(id);
    }

    public void createNewCustomer(Customer customer) {
        customer.setId(findMaxId());
        customerDb.put(customer.getId(), customer);
    }

    public void updateCustomer(Customer customer, Integer id) {
        Customer updatedCustomer = customerDb.get(id);
        updatedCustomer = customer;
    }

    public void deleteCustomer(int id) {
        customerDb.remove(customerDb.get(id));
    }

    public int findMaxId(){
        if(customerDb.isEmpty()){
            return 1;
        }else{
            SortedSet set = (SortedSet) customerDb.keySet();
            return (int) set.last();
        }
    }
}
