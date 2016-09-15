package inventory;

import java.sql.*;

public class Model extends Database {

    public Model() {

    }

    protected void selectUsers() throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("SELECT * FROM user");
        this.rs = this.pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("user_id")+": "+""+rs.getString("user")+" "+rs.getString("pass"));
        }
        this.closePst();
        this.closeConn();
    }
    
    protected void insertUser(String[] values) throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("INSERT INTO User(user, pass) VALUES(?, ?)");
//        this.pst.setString(1, id);
        this.pst.setString(1, values[0]);
        this.pst.setString(2, values[1]);
        this.pst.executeUpdate();
        this.closePst();
        this.closeConn();
    }
    
    protected void updateUser(String[] values, int id) throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("UPDATE user SET user = '"+values[0]+"', pass = '"+values[1]+"' WHERE user_id = "+id);
        this.pst.executeUpdate();
        this.closePst();
        this.closeConn();
    }
    
    protected void deleteUser(int id) throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("DELETE FROM user WHERE user_id = "+id);
        this.pst.executeUpdate();
        this.closePst();
        this.closeConn();
    }
}
