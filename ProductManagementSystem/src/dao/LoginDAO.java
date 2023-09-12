package dao;

import dbutil.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.LoginInfo;

public class LoginDAO {
public LoginDAO() {
}

public static boolean isUserValid(LoginInfo userDetails) {
   boolean validStatus = false;

   try {
      Connection conn = DBUtil.getConnection();
      Statement st = conn.createStatement();

      for(ResultSet rs = st.executeQuery("SELECT * FROM login_info WHERE username = '" + userDetails.getUserName() + "' AND password = '" + userDetails.getPassword() + "'"); rs.next(); validStatus = true) {
      }

      DBUtil.closeConnection(conn);
   } catch (Exception var5) {
      var5.printStackTrace();
   }

   return validStatus;
}
}

