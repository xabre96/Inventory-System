package inventory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    protected Connection con = null;
    private Statement st = null;
    protected PreparedStatement pst = null;
    protected ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/inventory";
    private String user = "root";
    private String password = "";

    public Database() {

    }

    protected void openConn() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void closeConn() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void setSt() {
        try {
            this.st = this.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void closeSt() {
        try {
            this.st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void prepare(String statement){
        try {
            this.st = this.con.prepareStatement(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void closePst(){
        try {
            this.pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void execute(){
        try {
            this.pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void execute(String statement) {
        try {
            this.rs = this.st.executeQuery(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void closeRs() {
        try {
            this.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
