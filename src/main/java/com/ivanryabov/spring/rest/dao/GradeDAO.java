package com.ivanryabov.spring.rest.dao;


import com.ivanryabov.spring.rest.entity.Grade;

import java.util.List;

public interface GradeDAO {

    public List<Grade> getAllGrades();

    public void addGrade(Grade grade);

    public void updateGrade(Grade grade);

    public void deleteGrade(int id);
}
