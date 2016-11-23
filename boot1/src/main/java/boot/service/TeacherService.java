package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TeacherRepository;
import boot.model.Teacher;

@Service	@Transactional
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	
	public TeacherService(TeacherRepository teacherRepository){
		super();
		this.teacherRepository=teacherRepository;
	}
	
	public List<Teacher> findAll(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		for (Teacher teacher: teacherRepository.findAll()){
			teachers.add(teacher);
		}
		return teachers;
	}
	
	public void save(Teacher teacher){
		teacherRepository.save(teacher);
	}
	
	public void delete(int id){
		teacherRepository.delete(id);
	}
	
	public Teacher findTeacher(int id){
		return teacherRepository.findOne(id);
	}

}
