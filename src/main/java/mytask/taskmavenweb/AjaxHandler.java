/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Subhan-apollo
 */
public class AjaxHandler {

//    String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//    String dbUser = "mehdi";
//    String dbPass = "123";

    @Autowired
    DBQueries tab;

    public List<Map<String, Object>> getCityData() {
        return tab.dbData();
    }

    public List<Map<String, Object>> getSubCityData(HttpServletRequest req) {
        String dbVal = req.getParameter("dropDown2");
        return tab.dbData2(dbVal);
    }
}
