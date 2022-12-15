package pl.waldi.RecruitmentProject.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is for data import
 */


public class DataImporter {
    /**
     * Method DataImporter is connectiong with database on certain url adress
     * @throws IOException signalizing problems with input/output system so when problem with files
     * or data transmission accures
     * @throws SQLException signalizing problems with database, open when importancy level is 10 or less, when
     * importancy level is 17 to 25 there is an errors with software or dev environment
     */
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
