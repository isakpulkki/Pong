package pong.data;

import java.sql.*;
import java.util.Objects;

/**
 * This class loads the database from SQLite
 */
public class ConfigDao {

    static String dbName;

    /**
     * Just makes connection to the database
     */
    public ConfigDao(String name) {
        try {
            // Create a database connection
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + name + ".db");
            dbName = name;
            createDatabase(connection);
            getConfigurations(connection);
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Gets different attributes from the database to the application's configuration
     */

    public static void createDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(createTable());
        try {
            statement.execute(createConfig());
        } catch (SQLException e) {
            System.out.println("Config -database was not created, it already exists");
        }
    }

    public static void getConfigurations(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM config");
        while (rs.next()) {
            // Read the result set
            Config.playerHeight = rs.getInt("playerHeight");
            Config.difficulty = rs.getInt("difficulty");
            Config.ballRadius = rs.getInt("ballRadius");
        }
    }
    /**
     * Updates value modified in SettingsScene
     */
    public static void updateValue(String row, int value) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE config SET " + row + " = " + value + " WHERE id = 1");
            if (row.equals("playerHeight")){
                Config.playerHeight = value;
            }
            else if (row.equals("difficulty")){
                Config.difficulty = value;
            }
            if (row.equals("ballRadius")){
                Config.ballRadius = value;
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates table if it does not exist
     */
    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS config(" +
                "id INTEGER PRIMARY KEY, " +
                "playerHeight INTEGER NOT NULL, " +
                "difficulty INTEGER NOT NULL," +
                "ballRadius INTEGER NOT NULL);";
    }

    /**
     * Creates the config column
     */
    public static String createConfig() {
        return "INSERT INTO config(" +
                "id, " +
                "playerHeight, " +
                "difficulty," +
                "ballRadius) values(1, 100, 10, 20)";
    }
}
