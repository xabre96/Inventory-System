
package inventory;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;


public class LoginController {
    public LoginController(){
        
    }
    
    protected boolean authentication(String[] values){
        UserModel um = new UserModel();
        
        try {
            um.checkUser(values);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
