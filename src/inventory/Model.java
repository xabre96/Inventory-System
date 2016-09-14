
package inventory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Model extends Database{
    public Model(){
        
    }
    
    protected void getVersion(){
        this.getConn();
        this.getStatement();
        this.setStatement("SELECT VERSION()");
        try {
            if (this.rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
