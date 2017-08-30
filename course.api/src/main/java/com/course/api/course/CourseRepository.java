package com.course.api.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
//or use JpaRepository<Topic, String>
/*	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);*/
	public List<Course> findByTopicId(String topicId);
}
