
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
    public void insertUpdateDeleteAppointment(char operation, String username, String hour, String minute, String date) throws SQLException{
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        String dateTime = date+" "+hour+":"+ minute;
        
        Timestamp aTime = convertStringToTimestamp(date);
        //i for insert
        if(operation == 'i'){
            ps = con.prepareStatement("INSERT INTO Appointments(user, apptDate) VALUES (?,?)");
        }
    }
    
    public static Timestamp convertStringToTimestamp(String str_date) {
    Timestamp tStamp = null;
    try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    Date parsedDate = (Date) dateFormat.parse(str_date);
    tStamp = new java.sql.Timestamp(parsedDate.getTime());
} catch(Exception e) { //this generic but you can control another types of exception
    // look the origin of excption 
}
      return tStamp;
    }
}
