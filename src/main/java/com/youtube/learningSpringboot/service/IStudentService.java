package com.youtube.learningSpringboot.service;

import com.youtube.learningSpringboot.dto.AddStudentRequestDTO;
import com.youtube.learningSpringboot.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
public interface IStudentService {
    List<StudentDTO>getAllStudent();

    StudentDTO getStudent(Long id);

    StudentDTO createdStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id,AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updateStudentPartially(Long id, Map<String, Object> updates);
}
