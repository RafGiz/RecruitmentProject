package pl.waldi.RecruitmentProject.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataImporter {
    public static void main(String[] args) throws IOException, SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/recruitmentproject";
        String username = "root";
        String password = "password";
        String excelFilePAth = "Users.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePAth);



        Connection connection = DriverManager.getConnection(jdbcURL, username, password);

        String sql = "INSERT INTO...";

        Statement statement = connection.createStatement();

        int rows = statement.executeUpdate(sql);
    }
}
