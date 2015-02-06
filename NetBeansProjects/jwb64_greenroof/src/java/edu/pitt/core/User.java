
package edu.pitt.core;

import edu.pitt.utilities.DbUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates the class, User, and creates private properties that
 * match all fields in the jwb64_greenroof database table users.
 * @author Joseph Beaumont
 */
public class User {
    private int userID;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private boolean isValidUser = false;

    /**
     * Constructor of User class that takes one parameter.
     * String variable sql is a SELECT SQL statement that concatenates the
     * parameter into a SQL statement to query a specific user based
     * on their unique user ID. 
     * Calls the setAllUsersProperties method with sql as the parameter.
     * Creates an instance of a user object
     * @param userID 
     */
    public User(int userID){
        String sql = "SELECT * FROM users WHERE userId = " + userID + "";
        setAllUserProperties(sql);
    }
    
    /**
     * Constructor of User class that takes two parameters.
     * String variable sql is a SELECT SQL statement that concatenates the
     * two parameters into a SQL statement to query a specific
     * user based on email and password.
     * Calls the setAllUsersProperties method with sql as the parameter.
     * 
     * Looks up user via user id and password
     * @param email
     * @param password Uses MD5 encryption
     */
    public User(String email, String password){
        String sql = "SELECT * FROM users WHERE email = '" + email + "' AND password = MD5('" + password + "')";
        setAllUserProperties(sql);
    }
    
    /**
     * Prints out the SQL statement created in the constructor.
     * Creates a new instance of the DbUtilities class, db.
     * Try/Catch statement that tests the database connection.
     * Try: Creates a new instance of the ResultSet class, rs,
     * which takes the generated sql statement and returns the results
     * from the database.
     * While loop that loops through all the properties in the database
     * to populate the entire ResultSet, then closes the databse connection.
     * Catch: If there is an error connecting to the database, this prints
     * out the trace to debug the error.
     * @param sql   Taken from the constructor.
     */
    private void setAllUserProperties(String sql){
        System.out.println(sql);
        DbUtilities db = new DbUtilities();
        try {
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.userID = rs.getInt("userId");
                this.lastName = rs.getString("lastName");
                this.firstName = rs.getString("firstName");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.isValidUser = true;
            }
            db.closeDbConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * @return the isValidUser
     */
    public boolean getIsValidUser() {
        return this.isValidUser;
    }
    
    


    
    
}
