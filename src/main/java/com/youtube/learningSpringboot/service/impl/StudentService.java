package com.youtube.learningSpringboot.service.impl;

import com.youtube.learningSpringboot.dto.AddStudentRequestDTO;
import com.youtube.learningSpringboot.dto.StudentDTO;
import com.youtube.learningSpringboot.entity.Student;
import com.youtube.learningSpringboot.repository.StudentRepository;
import com.youtube.learningSpringboot.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
      List<Student>allStudents=studentRepository.findAll();
      return allStudents
              .stream()
              .map(student -> modelMapper.map(student, StudentDTO.class))
              .toList();
    }

    @Override
    public StudentDTO getStudent(Long id) {
        Student student=studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("The User is not Exist"));
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO createdStudent(AddStudentRequestDTO addStudentRequestDTO) {
        Student student=modelMapper.map(addStudentRequestDTO,Student.class);
        studentRepository.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
//        Student student=studentRepository.findById(id).orElseThrow(()->  it is also a way.
//                new IllegalArgumentException("The User is not Exist so can't be deleted!"));
//        studentRepository.delete(student);
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("The User is not Exist so can't be deleted! ");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(Long id,AddStudentRequestDTO addStudentRequestDTO) {
        Student student=studentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("The User is not Exist so can't be deleted! "));
        modelMapper.map(addStudentRequestDTO,student);
        studentRepository.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudentPartially(Long id, Map<String, Object> updates) {
        Student student=studentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("The User is not Exist so can't be deleted! "));
        updates.forEach((value,change)->
                {
                    if(value.equals("name"))student.setName((String) change);
                    else if(value.equals("email"))student.setEmail((String)change);
                    else{
                        throw new IllegalArgumentException("This Change is not possible");
                    }
                }
                );
        return modelMapper.map(student,StudentDTO.class);
    }


}
