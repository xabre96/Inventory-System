
package inventory;

import java.sql.SQLException;


public class EmployeeModel extends Database{
    public EmployeeModel(){
        
    }
    
    protected void checkUser(String[] values) throws SQLException {
        this.openConn();
//        System.out.println(values[0]+" "+values[1]);
        this.pst = this.con.prepareStatement("SELECT * FROM user WHERE user='"+values[0]+"' AND pass='"+values[1]+"'");
        this.rs = this.pst.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
//            System.out.println(rs.getInt("user_id")+": "+""+rs.getString("user")+" "+rs.getString("pass"));
        }
        System.out.println(count);
        this.closeRs();
        this.closePst();
        this.closeConn();
    }
}
