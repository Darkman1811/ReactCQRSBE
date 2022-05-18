package com.guestu.reactcqrsbe.service;

import com.guestu.reactcqrsbe.domain.Project;
import com.guestu.reactcqrsbe.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }
    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    public Project updateProject(Project project){
        AtomicReference<Project> response= new AtomicReference<>(null);
        projectRepository.findById(project.getId()).ifPresent((linkedProject -> {
            linkedProject.setName(project.getName());
            response.set(projectRepository.save(linkedProject));

        }));

        return response.get();
    }

    public void deleteProject(Long id){
       projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }
}
