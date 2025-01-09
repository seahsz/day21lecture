package vttp.paf.day21lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day21lecture.model.Customer;
import vttp.paf.day21lecture.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    public List<Customer> getCustomers(int limit, int offset) {
        return customerRepo.getCustomersLimitOffset(limit, offset);
    }

    public List<Customer> getCustomersById(int id) {
        return customerRepo.getCustomersById(id);
    }

    public boolean deleteCustomerById(int id) {
        return customerRepo.deleteCustomerById(id);
    }

    public int updateCustomerById(String fullName, String email, int id) {
        return customerRepo.updateCustomerById(id, fullName, email);
    }

    public boolean insertCustomer(String fullName, String email) {
        return customerRepo.insertCustomer(fullName, email);
    }
    
}
