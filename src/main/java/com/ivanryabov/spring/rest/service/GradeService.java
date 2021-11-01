package com.ivanryabov.spring.rest.service;


import com.ivanryabov.spring.rest.entity.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getAllGrades();

    public void addGrade(Grade grade);

    public void updateGrade(Grade grade);

    public void deleteGrade(int id);
}
