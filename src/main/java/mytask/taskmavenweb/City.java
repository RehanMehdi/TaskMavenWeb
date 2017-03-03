/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Subhan-apollo
 */
public class City extends HttpServlet {

    private String city;
    private String sub_city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSub_city() {
        return sub_city;
    }

    public void setSub_city(String sub_city) {
        this.sub_city = sub_city;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            if (action.equals("getCityData")) {
                out.println(new AjaxHandler().getCityData());
            } else if (action.equals("getSubCityData")) {
                out.println(new AjaxHandler().getSubCityData(request));
            }
        } catch (Exception ex) {
        } finally {
            out.close();
        }
    }

}
