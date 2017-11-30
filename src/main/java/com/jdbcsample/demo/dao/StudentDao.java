package com.jdbcsample.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbcsample.demo.entity.Student;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSurname(rs.getString("surname"));
			return student;
		}
		
	}
	
	/*this is using customer rowmapper */
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}

	
	public Student findById(int id) {
		return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from student where id=?", new Object[] { id });
	}

	public int insert(Student student) {
		return jdbcTemplate.update("insert into student (id, name, surname) " + "values(?,  ?, ?)",
				new Object[] { student.getId(), student.getName(), student.getSurname(),
						});
	}

	public int update(Student student) {
		return jdbcTemplate.update("update student " + " set name = ?, surname = ? " + " where id = ?",
				new Object[] { student.getName(), student.getSurname(),
						student.getId() });
	}

}