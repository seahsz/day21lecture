package vttp.paf.day21lecture.utility;

public class Sql {

    public final static String getAllRooms = "select * from room";

    public final static String getAllCustomers = "select * from customer";

    public final static String getCustomersLimitOffset = "select * from customer limit ? offset ?";

    public final static String getCustomersById = "select * from customer where id = ?";

    public final static String deleteCustomersById = "delete from customer where id = ?";

    public final static String updateCustomersEmailById = "update customer set email = ? where id = ?";

    public final static String updateCustomersById = "update customer set full_name = ?, email = ? where id = ?";

    public final static String insertCustomer = "insert into customer (full_name, email) values (?, ?)";
    
}
