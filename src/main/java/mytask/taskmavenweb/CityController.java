/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Subhan-apollo
 */

@Controller
public class CityController {
    
     @RequestMapping(value = "/")
    public ModelAndView viewHome() {
        return new ModelAndView("city");
    }
    
}
