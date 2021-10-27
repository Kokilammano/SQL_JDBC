package assignment_7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ProductJdbcCon {
	public static void main(String[] args) {
		ProductDAO proDao=new ProductDAO();
		HashMap<ProductBean,Integer> pro = proDao.getProductInfo();
		Set st=pro.keySet();
		Iterator itr=st.iterator();
			
		System.out.println("Product Details are:");
		while(itr.hasNext()) {
			ProductBean product=(ProductBean)itr.next();
			System.out.printf("%2d %-20s %d%n",product.getProduct_id(),product.getName(),product.getPrice());	
		}
		System.out.println();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product name:");
		String name=sc.nextLine();
		
		int price=proDao.calBill(name);
		if(price==0)
			System.out.println(name+" is not available!!!");
		else
			System.out.println("The amount is Rs "+price);
		
	    sc.close();
		
	}
}


