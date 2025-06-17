package com.example.REST_API.service;

import com.example.REST_API.model.Student;
import com.example.REST_API.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
      @Autowired
      private StudentRepository studentrepository;

      public List<Student> getAllStudents(){
          return studentrepository.findAll();
      }
      public Student addStudent(Student student){
         return studentrepository.save(student);
      }
      public Student getStudentById(Long Id){
          return studentrepository.findById(Id).orElse(null);
      }
      public Student updateStudent(Long Id ,Student updatedstudent){
          Student student = getStudentById(Id);
          if (student != null) {
              student.setName(updatedstudent.getName());
              student.setEmail(updatedstudent.getEmail());
              return studentrepository.save(student);
          }
          return null;
      }
    public void deleteStudent(Long id) {
        studentrepository.deleteById(id);
    }

}
