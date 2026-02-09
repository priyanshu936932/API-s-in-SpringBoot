package com.youtube.learningSpringboot.controller;

import com.youtube.learningSpringboot.dto.AddStudentRequestDTO;
import com.youtube.learningSpringboot.dto.StudentDTO;
import com.youtube.learningSpringboot.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>>getALlStudents(){
        return ResponseEntity.ok(iStudentService.getAllStudent());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO>getStudentById(@RequestBody Long id){
        return ResponseEntity.ok(iStudentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO>createNewStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iStudentService.createdStudent(addStudentRequestDTO));
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Void>deleteUser(@RequestBody Long id){
        iStudentService.deleteStudentById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO>updateStudent(@PathVariable Long id ,@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok(iStudentService.updateStudent(id,addStudentRequestDTO));
    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentDTO>updatePartially(@PathVariable Long id, @RequestBody Map<String, Object>updates){
        return ResponseEntity.accepted().body(iStudentService.updateStudentPartially(id,updates));
    }
}
