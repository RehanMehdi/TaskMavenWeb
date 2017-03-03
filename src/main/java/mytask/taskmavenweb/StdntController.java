/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Subhan-apollo
 */
@Controller
//@RequestMapping("/spring")
public class StdntController {

    @Autowired
    DBQueries tab;

    //HOME PAGE
    @RequestMapping(value = "/")
    public ModelAndView viewHome() {
        return new ModelAndView("home");
    }
//    //HOME PAGE on button click
//    @RequestMapping(value = "/home")
//    public ModelAndView viewHome() {
//        return new ModelAndView("home");
//    }
     //INSERT DATA INTO DB
    @RequestMapping(value="/InsertServlet", method = RequestMethod.POST)
    public ModelAndView insertData(@ModelAttribute("s") Stdnt s){
        //tab.saveOrUpdate(s);
        tab.create(s);
    return new ModelAndView("redirect:/load");
    }
    
     //VIEW LOAD
    @RequestMapping(value="/load")
    public ModelAndView viewLoad(){
        List<Stdnt> list = tab.list();
        //List<Stdnt> listStudents = tab.listStudents();
        return new ModelAndView("load","list",list);
        //return new ModelAndView("load", "list", listStudents);
    }
    
    //View Page
    @RequestMapping(value="/view/{id}")
    public ModelAndView viewPage(@PathVariable("id") int id){
    
        Stdnt c = tab.findByStuID(id);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("Stdnt", c);
//        mav.setViewName("view");
//        return mav;
        return new ModelAndView("view", "Stdnt", c);
    }
    
    //LOAD CREATE PAGE
    @RequestMapping(value="/create")
    public ModelAndView viewCreate(){
        return new ModelAndView("create");
    }
    
    //DELETE DATA FROM DATABASE
    @RequestMapping(value="/deleteservlet/{id}")
    public ModelAndView delete(@PathVariable int id){
        tab.delete(id);
        return new ModelAndView("redirect:/load");
    }
    
    
    
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ModelAndView addStudent() {
//        return new ModelAndView("addStudent", "command", new Stdnt());
//    }
//
//    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//    public String addStudent(@ModelAttribute("myadd") Stdnt student,
//            ModelMap model) {
//        model.addAttribute("name", student.getName());
//        model.addAttribute("faculty", student.getFaculty());
//        model.addAttribute("reg", student.getReg());
//        model.addAttribute("gender", student.getGender());
//        model.addAttribute("age", student.getAge());
//        model.addAttribute("id", student.getId());
//
//        return "addStudent";
//    }

//    @RequestMapping(value="/myadd", method = RequestMethod.POST)
//    public @ResponseBody
//    Stdnt add(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//
//        Stdnt stu = new Stdnt();
//
//        String name = request.getParameter("name");
//        String faculty = request.getParameter("faculty");
//        String reg = request.getParameter("reg");
//        String gender = request.getParameter("gender");
//        String age = request.getParameter("age");
//
//        stu.setName(name);
//        stu.setFaculty(faculty);
//        stu.setReg(reg);
//        stu.setGender(gender);
//        stu.setAge(age);
//
//        return stu;
//    }
//    @RequestMapping(value = "/spring", method = RequestMethod.GET)
//    public void processData(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        final Resource r = new ClassPathResource("applicationContext.xml");
//        String Url = "file:///" + r.getFile();
        //String Url = "file:///C:/Users/ranaabuzar/Documents/NetBeansProjects/AirCommSpringProject/src/main/webapp/WEB-INF/applicationContext.xml";
//        String toReturn = "";
//
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(Url);
//        DBQueries db = (DBQueries) ctx.getBean("tab");
//        toReturn = db.getStu();
//        System.out.println(toReturn);

//        String toReturn = "";
//        try (PrintWriter out = response.getWriter()) {
//
//            String action = request.getParameter("action");
//            if (action.equals("getData")) {
//                ApplicationContext ctx = new ClassPathXmlApplicationContext(Url);
//                DBQueries db = (DBQueries) ctx.getBean("tab");
//                toReturn = db.getStu();
//                out.println(toReturn);
//            }
//
//        }
//    }

}
