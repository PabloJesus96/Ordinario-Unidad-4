package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.GraphRepository;
import boot.model.Graph;

@Service	@Transactional
public class GraphService {
	
	private final GraphRepository graphRepository;
	
	public GraphService(GraphRepository graphRepository){
		super();
		this.graphRepository = graphRepository;
	}
	
	public List<Graph> findAll(){
		List<Graph> graphs = new ArrayList<Graph>();
		for (Graph graph : graphRepository.findAll()){
			graphs.add(graph);
		}
		return graphs;
	}
	
	public void save(Graph graph){
		graphRepository.save(graph);
	}
	
	public void delete(int id){
		graphRepository.delete(id);
	}
	
	public Graph findGraph(int id){
		return graphRepository.findOne(id);
	}

}
