package inventory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection con = null;
    private Statement st = null;
    protected ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/inventory";
    private String user = "root";
    private String password = "";

    public Database() {

    }

    protected void getConn() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getStatement() {
        try {
            this.st = this.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void setStatement(String statement) {
        try {
            this.rs = this.st.executeQuery(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void closeRS() {
        try {
            this.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void closeStatement() {
        try {
            this.st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
