package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Graph;
import boot.service.GraphService;

@Controller
public class GraphController {
	
	@Autowired
	private GraphService graphService;
	
	@GetMapping("Graph")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "Graph";
	}
	
	@GetMapping("/all-graphs")
	public String allGraphs(HttpServletRequest request) {
		request.setAttribute("graph_path", graphService.findAll());
		request.setAttribute("mode", "MODE_GRAPHS");
		return "Graph";
	}

	// INSERTA UN GRAPH
	@GetMapping("/new-graph")
	public String newGraph(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "Graph";
	}
	
	//guarda un graph
	@PostMapping("/save-graph")
	public String saveGraph(@ModelAttribute Graph graph, BindingResult bindingResult, HttpServletRequest request) {
		graphService.save(graph);
		request.setAttribute("graph_path", graphService.findAll());
		request.setAttribute("mode", "MODE_GRAPHS");
		return "Graph";
	}
	
	//actualizar un graph
	@GetMapping("/update-graph")
	public String updateGraph(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("graph", graphService.findGraph(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "Graph";
	}
	
	//borra un graph
	@GetMapping("/delete-graph")
	public String deleteGraph(@RequestParam int id, HttpServletRequest request) {
		graphService.delete(id);
		request.setAttribute("graph_path", graphService.findAll());
		request.setAttribute("mode", "MODE_GRAPHS");
		return "Graph";
	}

}
