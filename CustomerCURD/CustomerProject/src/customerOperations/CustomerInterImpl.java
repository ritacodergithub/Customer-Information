package customerOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerInterImpl implements CustomerInter {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Customer customer;
	
	@Override
	public boolean addCustomer(Customer customer) {
		try
		{
			con=DataConnect.getConnect();
			ps=con.prepareStatement("insert into Customer values(?,?,?,?,?)");
			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcEmailId());
			ps.setString(3, customer.getcPassword());
			ps.setString(4, customer.getcAddress());
			ps.setString(5, customer.getcContactNo());
			
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean updateCustomerBYId(Customer customer) {
		try
		{
			con=DataConnect.getConnect();
			ps=con.prepareStatement("UPDATE Customer SET cName=?,cPassword=?,cAddress=?,cContactNo=? WHERE cEmailId=? ");
			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcPassword());
			ps.setString(3, customer.getcAddress());
			ps.setString(4, customer.getcContactNo());
			ps.setString(5, customer.getcEmailId());
			
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomerById(String cEmailId) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("DELETE FROM Customer WHERE cEmailId=? ");
			ps.setString(1, cEmailId);
			int row=ps.executeUpdate();
			if(row > 0 ) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> l=new ArrayList<Customer>();
		try
		{
			con=DataConnect.getConnect();
			ps=con.prepareStatement("SELECT *  FROM Customer ");
			rs=ps.executeQuery();
			while(rs.next()) {
				customer=new Customer();
				customer.setcName(rs.getString("cName"));
				customer.setcEmailId(rs.getString("cEmailId"));
				customer.setcPassword(rs.getString("cPassword"));
				customer.setcAddress(rs.getString("cAddress"));
				customer.setcContactNo(rs.getString("cContactNo"));
				
				l.add(customer);
			}
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		return l;
	}


}
