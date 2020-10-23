package xamppdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonGatway {
    private Connection getConnection() {
        Connection con;  
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            return con;
        }
        catch(Exception ex){
            return null;
        }
    }
    public boolean insertData(Person p2) 
    {
        String insertQuery="INSERT INTO person2(name,address,phone,email) VALUES('"+p2.getName()+"','"+p2.getAddress()+"','"+p2.getPhone()+"','"+p2.getEmail()+"')";
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            st.executeUpdate(insertQuery);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }   
    public ArrayList<Person> getData() {
        ArrayList<Person> pl1  = new ArrayList<Person>();
        String getQuery="SELECT *  FROM person2";
        Connection con=getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=con.createStatement();
            rs=st.executeQuery(getQuery);
            while(rs.next()){
                Person p5 = new Person();
                p5.setId(rs.getInt("id"));
                p5.setName(rs.getString("name"));
                p5.setAddress(rs.getString("address"));
                p5.setPhone(rs.getString("phone"));
                p5.setEmail(rs.getString("email"));
                pl1.add(p5);
            }
            return pl1;
        }
        catch(Exception ex){
            return null;
        }
    } 
    public boolean updateData(Person p3) 
    {
        String updateQuery="UPDATE person2  set name='"+p3.getName()+"',address='"+p3.getAddress()+"',phone='"+p3.getPhone()+"',email='"+p3.getEmail()+"' WHERE id='"+p3.getId()+"'";
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            st.executeUpdate(updateQuery);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    } 
    public boolean deleteData(Person p4) 
    {
        String deleteQuery="DELETE FROM person2 WHERE id='"+p4.getId()+"'";
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            st.executeUpdate(deleteQuery);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    } 
}
