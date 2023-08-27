package customerOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class CustomerTest {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String cName,cEmailId,cPassword,cAddress,cContactNo;
		
		CustomerInterImpl customerobj=new CustomerInterImpl();

		while(true)
		{
			System.out.println("1. Add");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. ShowAll");

			System.out.println("Enter Choice : ");
			int choice= sc.nextInt();
			boolean b;
			
			switch (choice) {
			case 1: {
				System.out.println("Enter How many food you want to add");
				int num=sc.nextInt();
				for(int i=1; i<=num ; i++) {
					System.out.println("Enter Customer Name : ");
					cName=br.readLine();
					System.out.println("Enter Email Id: ");
					cEmailId=br.readLine();
					System.out.println("Enter Customer Password: ");
					cPassword=br.readLine();
					System.out.println("Enter Customer Address: ");
					cAddress=br.readLine();
					System.out.println("Enter Customer ContactNo: ");
					cContactNo=br.readLine();

					b=customerobj.addCustomer(new Customer (cName,cEmailId,cPassword,cAddress,cContactNo));
					if(b) {
						System.out.println("Successfully Add...");
					}
					else
					{
						System.out.println("Failed...");
					}
				}
			}
			break;
			case 2:
			{
				
				System.out.println("Enter Email Id TO Update: ");
				cEmailId=br.readLine();
				System.out.println("Enter Customer Name  ");
				cName=br.readLine();
				System.out.println("Enter Customer Password: ");
				cPassword=br.readLine();
				System.out.println("Enter Customer Address: ");
				cAddress=br.readLine();
				System.out.println("Enter Customer ContactNo: ");
				cContactNo=br.readLine();

				b=customerobj.updateCustomerBYId(new Customer (cName,cEmailId,cPassword,cAddress,cContactNo));
				if(b) {
					System.out.println("Successfully Update ...");
				}
				else
				{
					System.out.println("Failed...");
				}
			}
			break;
			case 3:
			{
				System.out.println("Enter EmailId to Delete: ");
				cEmailId=br.readLine();
				b=customerobj.deleteCustomerById(cEmailId);
				if(b) {
					System.out.println("Successfully Delete...");
				}
				else
				{
					System.out.println("Failed...");
				}
				
			}
			break;
			
			case 4:
			{
				List<Customer >l =customerobj.getAllCustomer();
				Iterator<Customer> it=l.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			break;
			}
			
			}
	}

}
