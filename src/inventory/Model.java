package inventory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model extends Database {

    public Model() {

    }

    protected void getVersion() {
        this.openConn();
        this.setSt();
        this.execute("SELECT VERSION()");
        try {
            if (this.rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void insertUser() throws SQLException {
        String user = "xan";
        String pass = "123";
        this.openConn();
        this.prepare("INSERT INTO User(user, pass) VALUES(?, ?)");
        this.pst.setString(1, user);
        this.pst.setString(2, pass);
        this.execute();
        this.closePst();
        this.closeConn();
    }

    protected void selectUser() throws SQLException {
        this.openConn();
        this.pst = this.con.prepareStatement("SELECT * FROM user");
        this.rs = this.pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt("user_id"));
            System.out.print(": ");
            System.out.print(rs.getString("user"));
            System.out.println(rs.getString("pass"));
        }
        this.closePst();
        this.closeConn();
    }
}
