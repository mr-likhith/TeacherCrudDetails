package com.StudentDashBoard.TeacherCrudDetails.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.StudentDashBoard.TeacherCrudDetails.Services.StudentAtdService;
import com.StudentDashBoard.TeacherCrudDetails.Services.StudentService;
import com.StudentDashBoard.TeacherCrudDetails.Services.UserService;
import com.StudentDashBoard.TeacherCrudDetails.model.Student;
import com.StudentDashBoard.TeacherCrudDetails.model.StudentAttendance;
import com.StudentDashBoard.TeacherCrudDetails.model.UserModel;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentAtdService attservice;
	
	@GetMapping("/login")
	public String getLoginPage(Model model)
	{
		model.addAttribute("loginRequest",new UserModel());
		return "login_page";
	}
	@GetMapping("/register")
	public String getRegisterPage(Model model)
	{
		model.addAttribute("registerRequest",new UserModel());
		return "register_page";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute UserModel userModel)
	{
		System.out.println("register request" +userModel);
		UserModel registredUser=userService.registerUser(userModel.getLogin(),userModel.getPassword(),userModel.getUsername());
		return registredUser==null?"error_page":"redirect:/login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute UserModel userModel,Model model)
	{
		System.out.println("register request" +userModel);
		UserModel authenticated =userService.authenticate(userModel.getLogin(),userModel.getPassword());
		if(authenticated !=null)
		{
			model.addAttribute("userLogin", authenticated.getLogin());
			return "home_page";
		}else {
			return "error_page";
		}
	}
	
	
	//Student controller
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		List<Student> listStudent=service.listAll();
		model.addAttribute("listStudent",listStudent);
		System.out.println("Get / ");
		return "home_page";
	}
	@GetMapping("/addStudent")
	public String add(Model model)
	{
		List<Student> listStudent=service.listAll();
		model.addAttribute("student",new Student());
		return "addStudent";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student")Student std)
	{
		service.save(std);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name="id") Long id)
	{
		ModelAndView mav= new ModelAndView("addStudent");
		Student std=service.get(id);
		mav.addObject("student",std);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name="id") Long id)
	{
		service.delete(id);
		return "redirect:/";
	} 
	 @GetMapping("/home_page")
	 public String homePage(Model model)
	{
	   	List<Student> listStudent=service.listAll();
		model.addAttribute("listStudent",listStudent);
		System.out.println("Get / ");
		return "home_page";
	 }
	
	//Attendance details
	    
	 @GetMapping("/viewattendance")
	 public String viewAttendance(Model model) {
	     List<StudentAttendance> listAttendance = attservice.listAll();
	     model.addAttribute("listAttendance", listAttendance);
	     System.out.println("Get / ");
	     return "viewattendance";
	 }

	 @GetMapping("/addattendance")
	 public String addAttendance(Model model) {
	     model.addAttribute("attend", new StudentAttendance());
	     return "addattendance";
	 }

	 @RequestMapping(value = "/saved", method = RequestMethod.POST)
	 public String saveAttendance(@ModelAttribute("attendt") StudentAttendance atd) {
	     attservice.saved(atd);
	     return "redirect:/addattendance";
	 }

	 @RequestMapping("/change/{id}")
	 public ModelAndView showEditAttendance(@PathVariable(name = "id") Long id) {
	     ModelAndView mav = new ModelAndView("addattendance");
	     StudentAttendance atd = attservice.get(id);
	     mav.addObject("attend", atd);
	     return mav;
	 }

	 @RequestMapping("/remove/{id}")
	 public String deleteAttendance(@PathVariable(name = "id") Long id) {
	     attservice.remove(id);
	     return "redirect:/viewattendance";
	 }
	 @PostMapping("/addattendance")
	 public String attendancePage(Model model)
	{
	   	List<StudentAttendance> listAttendance=attservice.listAll();
		model.addAttribute("listAttendance",listAttendance);
		System.out.println("Get / ");
		return "addattendance";
	 }

}

