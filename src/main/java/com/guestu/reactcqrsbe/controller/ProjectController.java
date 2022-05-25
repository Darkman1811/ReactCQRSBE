package com.guestu.reactcqrsbe.controller;

import com.guestu.reactcqrsbe.domain.Project;
import com.guestu.reactcqrsbe.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    Logger logger= LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    ProjectService projectService;

    @GetMapping()
    public List<Project> getAllProjects(){
        return projectService.getAllProject();
    }

    @PostMapping()
    public Project addProject(@RequestBody Project project){
        logger.warn("================================= adding project: "+project.toString()+" =================================");
     return projectService.addProject(project);
    }

    @PutMapping()
    public Project updateProject(@RequestBody Project project){
        logger.warn("================================= updating  project"+project.toString()+" =================================");
        return projectService.updateProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        logger.warn("================================= updating  project =================================");
         projectService.deleteProject(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Project getProjectById(@PathVariable Long id){
        logger.warn("================================= Getting  project By Id =================================");
        Project result= projectService.getProjectById(id);
        return result;
    }


}
