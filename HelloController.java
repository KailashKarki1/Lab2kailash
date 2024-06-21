package com.example.csd214lab2kailash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
public class HelloController implements Initializable {
    public Label welcomeText;
    public TextField xid;
    public TextField xbank;
    public TextField xusername;
    public TextField xpassword;
    @FXML
    private TableView<mytable> tableView;
    @FXML
    private TableColumn<mytable, Integer> id;
    @FXML
    private TableColumn<mytable, String> bank;
    @FXML
    private TableColumn<mytable, String> username;
    @FXML
    private TableColumn<mytable, String> password;
    ObservableList<mytable> list = FXCollections.observableArrayList();

    public void onHelloButtonClick(ActionEvent actionEvent) {

        populateTable();
    }

    public void populateTable() {
        list.clear();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2kailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM mytable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String bank = resultSet.getString("bank");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                tableView.getItems().add(new mytable(id, bank, username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<mytable, Integer>("id"));
        bank.setCellValueFactory(new PropertyValueFactory<mytable, String>("bank"));
        username.setCellValueFactory(new PropertyValueFactory<mytable, String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<mytable, String>("password"));
        tableView.setItems(list);


    }

    public void InsertData(ActionEvent actionEvent) {
        String bank = xbank.getText();
        String username = xusername.getText();
        String password = xpassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2kailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `mytable`( `bank`, `username`, `password`) VALUES ('" + bank + "','" + username + "','" + password + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String id = xid.getText();
        String bank = xbank.getText();
        String username = xusername.getText();
        String password = xpassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2kailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `mytable` SET `bank`='" + bank + "',`username`='" + username + "',`password`='" + password + "' WHERE id='" + id + "' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void DeleteData(ActionEvent actionEvent) {
        String id = xid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2kailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `mytable` WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void LoadData(ActionEvent actionEvent){
            String id = xid.getText();
            String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab2kailash";
            String dbUser = "root";
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {
                // Execute a SQL query to retrieve data from the database
                String query = "SELECT * FROM mytable WHERE id='" + id + "'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                // Populate the table with data from the database
                while (resultSet.next()) {

                    String bank = resultSet.getString("bank");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");

                    xbank.setText(bank);
                    xusername.setText(username);
                    xpassword.setText(password);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }}