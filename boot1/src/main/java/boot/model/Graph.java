package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="graph_path")
public class Graph implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="term1_id")
	private int term1Id;
	@Column(name="term2_id")
	private int term2Id;
	@Column(name="relationship_type_id")
	private int relationshipTypeId;
	private int distance;
	@Column(name="relation_distance")
	private int relationDistance;
	
	/*Generacion de constructores*/
	public Graph(int term1Id, int term2Id, int relationshipTypeId, int distance, int relationDistance) {
		super();
		this.term1Id = term1Id;
		this.term2Id = term2Id;
		this.relationshipTypeId = relationshipTypeId;
		this.distance = distance;
		this.relationDistance = relationDistance;
	}
	
	public Graph(){
		this(0,0,0,0,0);
	}
	
	/*eneracion de setters and Getters*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTerm1Id() {
		return term1Id;
	}

	public void setTerm1Id(int term1Id) {
		this.term1Id = term1Id;
	}

	public int getTerm2Id() {
		return term2Id;
	}

	public void setTerm2Id(int term2Id) {
		this.term2Id = term2Id;
	}

	public int getRelationshipTypeId() {
		return relationshipTypeId;
	}

	public void setRelationshipTypeId(int relationshipTypeId) {
		this.relationshipTypeId = relationshipTypeId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getRelationDistance() {
		return relationDistance;
	}

	public void setRelationDistance(int relationDistance) {
		this.relationDistance = relationDistance;
	}

	@Override
	public String toString() {
		return "Graph [id=" + id + ", term1Id=" + term1Id + ", term2Id=" + term2Id + ", relationshipTypeId="
				+ relationshipTypeId + ", distance=" + distance + ", relationDistance=" + relationDistance + "]";
	}
	
	/*Generacion de metodo ToString*/
	
	

	
	
}
