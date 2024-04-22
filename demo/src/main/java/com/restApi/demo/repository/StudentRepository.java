package com.restApi.demo.repository;

import com.restApi.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository <Student,Integer>{

}
