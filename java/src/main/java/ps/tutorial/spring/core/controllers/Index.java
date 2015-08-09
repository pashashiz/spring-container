package ps.tutorial.spring.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ps.tutorial.spring.core.beans.*;
import ps.tutorial.spring.core.data.User;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class Index {

    @Autowired
    Tree tree;

    @Autowired
    ConfigResource logConfig;

    @Autowired
    ConfigResource webConfig;

    @Value("#{systemEnvironment}")
    Map systemEnv;

    @Value("#{systemProperties}")
    Map systemProperties;

    @Value("#{environment}")
    Environment environment;

    @RequestMapping("/")
    public void index(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("Hello " + tree);
        out.println("Log config " + logConfig);
        out.println("Web config " + webConfig);
    }

    @RequestMapping("/spel")
    public void spel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        ExpressionParser parser = new SpelExpressionParser();
        // Just string
        Expression exp = parser.parseExpression("'Hello World'");
        out.println("SpEL: " + exp.getValue(String.class));
        // Java code
        Expression exp1 = parser.parseExpression("new String('hello world').toUpperCase()");
        out.println("SpEL: " + exp1.getValue(String.class));
        // With custom context
        EvaluationContext context = new StandardEvaluationContext(tree);
        Expression exp2 = parser.parseExpression("'Apple: ' + apple");
        out.println("SpEL: " + exp2.getValue(context, String.class));
    }

    @RequestMapping("/spel-auto")
    public void spelAuto(@Value("#{tree.apple}") Apple apple, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("SpEL: " + apple);
        out.println("SpEL: " + environment);
        out.println("SpEL: " + systemEnv);
        out.println("SpEL: " + systemProperties);
    }

    @RequestMapping("/aspectj")
    public void aspectj(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("Check log to see aspects");
        Fruit apple = (Fruit)tree.getApple();
        out.println("Is apple eco friendly: " + apple.isEcoFriendly());
        tree.getPear();
        // Try to create non-managed by context bean and check AOP
        Tree nonManagedTree = new Tree(new Apple(), new Pear());
        nonManagedTree.getPear();
        nonManagedTree.getApple();
        // Yes! It works for it
    }

    @RequestMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("message", "Hello");
        return "index";
    }

    @RequestMapping("/url-template/{value}")
    public String urlTemplate(@PathVariable String value, Model model) {
        model.addAttribute("message", value);
        return "index";
    }

    @RequestMapping("/url-template-expr/{name:[a-z]+}-{version:\\d+}")
    public String urlTemplateExpression(@PathVariable String name, @PathVariable int version, Model model) {
        model.addAttribute("message", "name: " + name + ", version: " + version);
        return "index";
    }

    @RequestMapping("/user")
    public String getUser(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        user.setFirstName("Pasha-" + user.getFirstName());
        return "user";
    }

    @RequestMapping(value = "/json-producer")
    public @ResponseBody User jsonProducer() {
        return new User();
    }

}
