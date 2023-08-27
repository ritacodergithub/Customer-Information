package customerOperations;

import java.util.List;

public interface CustomerInter {
	boolean addCustomer(Customer customer);
	boolean updateCustomerBYId(Customer customer);
	boolean deleteCustomerById(String cEmailId);
	List<Customer> getAllCustomer();
}
