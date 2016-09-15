package inventory;

import java.sql.*;

public class Inventory {
    
    public static void main(String[] args) throws SQLException {
        Model m = new Model();
        String[] user = new String[]{"Xan Gutierrez","Password"};
//        m.insertUser(user);
//        m.deleteUser(6);
//        m.updateUser(user, 4);
        m.selectUsers();
    }
    
}
