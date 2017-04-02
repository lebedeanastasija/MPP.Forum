package simple.blog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import org.hibernate.Session;
//import simple.blog.app.entity.ClientEntity;
//import simple.blog.app.persistence.HibernateUtil;

//import java.util.List;

import simple.blog.app.controller.exception.ControllerException;
import simple.blog.app.entity.Client;
import simple.blog.app.entity.util.UserData;
import simple.blog.app.service.exception.ServiceException;
import simple.blog.app.service.impl.UserService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class AuthController {

    /*@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "The last registered user ");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ClientEntity user = new ClientEntity();
        user.setLogin("nastya6");
        user.setPassword("12345");
        user.setBanned((byte)0);
        session.save(user);

        String name =  ((ClientEntity)session.get(ClientEntity.class, 1)).getLogin();
        List clients = session.createCriteria(ClientEntity.class).list();
        model.addObject("name", name);
        model.addObject("usersNumber", clients.size());

        session.getTransaction().commit();
        return model;
    }*/

    @Autowired
    @Qualifier("UserService")
    private UserService userService;



    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public @ResponseBody ModelAndView get() {

        ModelAndView model = new ModelAndView("AuthSignUp");
        model.addObject("msg", "Hello, user!");
        return model;

    }

    @RequestMapping(value="/signup/create", method=RequestMethod.POST)
    public @ResponseBody ModelAndView get(@ModelAttribute("userData") UserData data, Map<String, Object> map) {
        ModelAndView model = new ModelAndView("AuthSignUpSuccess");
        try {
            Client user = userService.createUser(data);
            map.put("userData", data);
            model.addObject("msg", "OK");
            return model;
        } catch (ServiceException exception) {
            model.addObject("msg", "Controller layer: " + exception.getMessage());
            return model;
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("YYYY-mm-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }
}
