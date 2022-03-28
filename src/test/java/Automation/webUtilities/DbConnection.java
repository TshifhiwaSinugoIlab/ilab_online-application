package Automation.webUtilities;

import Automation.data.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

    public ResultSet ConnectDb() {
        data connect = new data();
        ResultSet FillingFormData;

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String user = "root";
        String pass = "password";


        String credQuery = "select * from apply";
        FillingFormData = connect.ConnectAndQuerySQL(url, user, pass, credQuery);

        return FillingFormData;
    }
}
