package com.guestu.reactcqrsbe.repository;

import com.guestu.reactcqrsbe.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
