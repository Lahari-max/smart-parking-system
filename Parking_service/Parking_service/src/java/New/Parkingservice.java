/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "Parkingservice")
public class Parkingservice {

    /**
     * This is a sample web service operation
     * @param username
     * @param password
     * @param mail
     * @param mobile
     * @return 
     */
   @WebMethod(operationName = "Register")
  public String Register(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String mail, @WebParam(name = "mobile") String mobile) {
    try
    {  
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
    PreparedStatement ps=con.prepareStatement("Insert into user(username,password,mail,mobile) Values(?,?,?,?)");
    ps.setString(1, username);
    ps.setString(2, password);
    ps.setString(3, mail);
    ps.setString(4, mobile);
    ps.executeUpdate();
    }
        catch(ClassNotFoundException | SQLException e)
        {            
        System.out.println(e);
        }
     return "success";
        
    }
   @WebMethod(operationName = "Login")
  public String Login(@WebParam(name = "user_name") String user_name, @WebParam(name = "password") String password) {
    try{
     Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
      Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("Select * from user where username='"+user_name+"' and password='"+password+"' ");
     if(rs.next())
     {
         return "success";
         
     }
     else{
    return "username and password invalid";
     } 
    
    }
        catch(Exception e){
        e.printStackTrace();
        }
        return "internal server error";
       
  }
  
  @WebMethod(operationName = "getDeviceList1")
     public String getDeviceList1 (@WebParam(name = "from") String vegitable,String method) {
   
     StringBuilder sb = new StringBuilder();
   try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("select * from slots ");       
           while(rs.next())
           {    
                String place=rs.getString("place");
                String slots=rs.getString("slots");
                String price=rs.getString("price");
                
                sb.append("Place: ").append(place);
                sb.append("\n"); 
                sb.append("AvailableSlots: ").append(slots);
                sb.append("\n");
                sb.append("Price: ").append(price);
                sb.append("@");
                
            }
     
               
    }
       catch(ClassNotFoundException | SQLException ex){
         //Logger.getLogger(Registration.class.getName()).log(Level.SEVERE,null,ex);
         return "server temporarily not avilable";
       }
        System.out.println(sb.toString());
        return sb.toString();
        
     }
      @WebMethod(operationName = "BankDetails")
  public String BankDetails(@WebParam(name = "name") String name, @WebParam(name = "accountno") String accountno, @WebParam(name = "cvv") String cvv, @WebParam(name = "expirydate") String expirydate,@WebParam(name = "password") String password) {
    try{

     
      
     Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
     PreparedStatement ps=con.prepareStatement("Insert into bankdetails(name,accountno,cvv,expirydate,password) Values('"+name+"','"+accountno+"','"+cvv+"','"+expirydate+"','"+password+"')");
    ps.executeUpdate();
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        
        return "success";
        
    } 
  
  
  @WebMethod(operationName = "BLogin")
  public String BLogin(@WebParam(name = "user_name") String user_name, @WebParam(name = "password") String password) {
    try{
     Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
      Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("Select * from bankdetails where name='"+user_name+"' and password='"+password+"' ");
     if(rs.next())
     {
         return "success";
         
     }
     else{
    return "username and password invalid";
     }
     
    
    }
        catch(Exception e){
        e.printStackTrace();
            System.out.println(e);
        }
        return "internal server error";
       
  }
  
  


  @WebMethod(operationName = "Sms")
  public String Sms(@WebParam(name = "phone") String phno) {
    try{      
     Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newpark","root","password");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("Select * from user where mobile='"+phno+"'");
     if(rs.next())
     {
         return "success";
         
     }
     else
     {
    return "mobile number is invalid";
     }
    }
      catch(Exception e){
        e.printStackTrace();
              System.out.println(e);
        }
        return "internal server error";
    }//
  }
  

