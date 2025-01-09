package vttp.paf.day21lecture.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp.paf.day21lecture.model.Customer;
import vttp.paf.day21lecture.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerSvc;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerSvc.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/limitoffset")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam int limit,
            @RequestParam int offset) {

        List<Customer> customers = customerSvc.getCustomers(limit, offset);

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCustomersById(
            @PathVariable String id) {

        try {

            int idAsInt = Integer.parseInt(id);

            List<Customer> customers = customerSvc.getCustomersById(idAsInt);

            return ResponseEntity.ok().body(customers);

        } catch (NumberFormatException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(400))
                    .body("Id provided is not valid, error converting id to a number");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerById(
            @PathVariable String id) {
        try {

            int idAsInt = Integer.parseInt(id);

            boolean isCustomerDeleted = customerSvc.deleteCustomerById(idAsInt);

            return ResponseEntity.ok().body(isCustomerDeleted);

        } catch (NumberFormatException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(400))
                    .body("Id provided is not valid, error converting id to a number");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomerById(
        @PathVariable String id,
        @RequestParam(name = "full_name") String fullName,
        @RequestParam String email
    ) {

        try {

            int idAsInt = Integer.parseInt(id);

            int numCustomerUpdated = customerSvc.updateCustomerById(fullName, email, idAsInt);

            return ResponseEntity.ok().body(numCustomerUpdated);

        } catch (NumberFormatException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(400))
                    .body("Id provided is not valid, error converting id to a number");
        }


    }

    @PostMapping("/insert")
    public ResponseEntity<Boolean> insertCustomer(
        @RequestBody MultiValueMap<String, String> form
    ) {

        boolean isCustomerInserted = customerSvc.insertCustomer(form.getFirst("fullName"), form.getFirst("email"));

        return ResponseEntity.ok().body(isCustomerInserted);

    }

}
