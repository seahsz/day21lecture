package vttp.paf.day21lecture.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day21lecture.model.Customer;
import vttp.paf.day21lecture.utility.Sql;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;
    
    public List<Customer> getAllCustomers() {

        List<Customer> result = template.query(Sql.getAllCustomers, 
            (rs, rowNum) -> {
                Customer customer = new Customer(rs.getInt("id"),
                                                 rs.getString("full_name"), 
                                                 rs.getString("email"));
                return customer;
            });

        return result;
    }

    public List<Customer> getCustomersLimitOffset(int limit, int offset) {

        List<Customer> result = new LinkedList<>();

        SqlRowSet rowSet = template.queryForRowSet(Sql.getCustomersLimitOffset, limit, offset);

        while (rowSet.next()) {
            result.add(new Customer(rowSet.getInt("id"), 
                rowSet.getString("full_name"), 
                rowSet.getString("email")));
        }

        return result;
    }

    public List<Customer> getCustomersById(int id) {

        List<Customer> result = new LinkedList<>();

        SqlRowSet rowSet = template.queryForRowSet(Sql.getCustomersById, id);

        while (rowSet.next()) {
            result.add(new Customer(rowSet.getInt("id"), 
                rowSet.getString("full_name"), 
                rowSet.getString("email")));
        }

        return result;
    }

    public boolean deleteCustomerById (int id) {

        int isCustomerDeleted = template.update(Sql.deleteCustomersById, id);

        if (isCustomerDeleted > 0)
            return true;

        return false;
    }

    public int updateCustomerById(int id, String fullName, String email) {

        int numCustomerUpdated = template.update(Sql.updateCustomersById, fullName, email, id);

        return numCustomerUpdated;
    }

    public boolean insertCustomer(String fullName, String email) {
        
        int isCustomerInserted = template.update(Sql.insertCustomer, fullName, email);

        if (isCustomerInserted > 0)
            return true;

        return false;
    }
}
