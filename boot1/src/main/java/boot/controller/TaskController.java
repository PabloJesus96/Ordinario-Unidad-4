package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Task;

import boot.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService TaskService;

	@GetMapping("Task")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "Task";
	}

	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request) {
		request.setAttribute("tasks", TaskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "Task";
	}

	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "Task";
	}

	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
		TaskService.save(task);
		request.setAttribute("tasks", TaskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "Task";
	}

	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("task", TaskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "Task";
	}

	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request) {
		TaskService.delete(id);
		request.setAttribute("tasks", TaskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "Task";
	}

	
}
