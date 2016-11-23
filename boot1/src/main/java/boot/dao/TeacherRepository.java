package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
