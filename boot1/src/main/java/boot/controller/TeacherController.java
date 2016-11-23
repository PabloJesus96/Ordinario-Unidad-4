package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Teacher;
import boot.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("Teacher")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "Teacher";
	}
	
	// RETORNA TODOS LOS PROFESORES
		@GetMapping("/all-teachers")
		public String allTeachers(HttpServletRequest request) {
			request.setAttribute("teachers", teacherService.findAll());
			request.setAttribute("mode", "MODE_TEACHERS");
			return "Teacher";
		}

		// INSERTA UN PROFESOR
		@GetMapping("/new-teacher")
		public String newTeacher(HttpServletRequest request) {
			request.setAttribute("mode", "MODE_NEW");
			return "Teacher";
		}
		
		//guarda un profesor
		@PostMapping("/save-teacher")
		public String saveTeacher(@ModelAttribute Teacher teacher, BindingResult bindingResult, HttpServletRequest request) {
			teacherService.save(teacher);
			request.setAttribute("teachers", teacherService.findAll());
			request.setAttribute("mode", "MODE_TEACHERS");
			return "Teacher";
		}
		
		//actualizar un profesor
		@GetMapping("/update-teacher")
		public String updateTeacher(@RequestParam int id, HttpServletRequest request) {
			request.setAttribute("teacher", teacherService.findTeacher(id));
			request.setAttribute("mode", "MODE_UPDATE");
			return "Teacher";
		}
		
		//borra un profesor
		@GetMapping("/delete-teacher")
		public String deleteTeacher(@RequestParam int id, HttpServletRequest request) {
			teacherService.delete(id);
			request.setAttribute("teachers", teacherService.findAll());
			request.setAttribute("mode", "MODE_TEACHERS");
			return "Teacher";
		}

}
