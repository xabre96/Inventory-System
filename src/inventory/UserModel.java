
package inventory;

import java.sql.SQLException;


public class UserModel extends Database {
    public UserModel(){
        
    }
    
    protected void checkUser(String[] values) throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("SELECT * FROM user WHERE user='"+values[0]+"' AND pass='"+values[1]+"'");
        this.rs = this.pst.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
        }
        System.out.println(count);
        this.closeRs();
        this.closePst();
        this.closeConn();
    }
}
