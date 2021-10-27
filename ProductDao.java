package assignment_7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
	
public class ProductDAO {
	Connection getDBConnection(){
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","kokilam" );
		} 
		catch (SQLException e) {
			System.out.println(e);
		} 
		return con; 
		}
		
	HashMap<ProductBean,Integer> getProductInfo(){
		HashMap<ProductBean,Integer> pro=new LinkedHashMap<ProductBean,Integer>();
		Connection con=getDBConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select id,name,price from Product");
			int i=0;
			while(rs.next()) {  
				ProductBean product=new ProductBean();
				product.setProduct_id(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				pro.put(product,i);
				i++;
			}
			con.close();
	
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return pro;
		   }
		
		public int calBill(String name){
			   Connection con=getDBConnection();
			   int price=0;
			   try {
				Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select price from Product where name= '"+name+"'"); 
				while(rs.next()) { 
				       price = rs.getInt("price");
				     
			    }
				con.close();
	
			   } catch (SQLException e) {
				   System.out.println(e);
			}
			   
			   return price;
		   }
	
	}
