
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class appointment {

    /**
     *
     * @param operation
     * @param username
     * @param hour
     * @param minute
     * @param date
     */
    public void insertUpdateDeleteAppointment(char operation, String username, String hour, String minute, Timestamp date){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        String aDate = date+ " "+hour+":"+ minute;
        Timestamp aTime = convertStringToTimestamp(aDate);
        //i for insert
        if(operation == 'i'){
            try{
            ps = con.prepareStatement("INSERT INTO Appointments(user, apptDate) VALUES (?,?)");
            ps.setString(1, username);
            ps.setTimestamp(2, aTime);
            }
            catch(SQLException ex){
            }
        }
    }
    
    /**
     *
     * @param aDate
     * @return
     */
    public static Timestamp convertStringToTimestamp(String aDate) {
    Timestamp tStamp = null;
    try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    Date parsedDate = (Date) dateFormat.parse(aDate);
    tStamp = new java.sql.Timestamp(parsedDate.getTime());
} catch(Exception e) { //this generic but you can control another types of exception
    // look the origin of excption 
}
      return tStamp;
    }
}
