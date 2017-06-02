package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.DependenciesTask;
import net.proselyte.springsecurityapp.model.Task;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.DependenciesTaskService;
import net.proselyte.springsecurityapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class TaskController {


    @Autowired
    private TaskService taskService;

    @Autowired
    private DependenciesTaskService dependenciesTaskService;




    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public String createTask(Model model) {

        model.addAttribute("taskForm", new Task());
      //  model.addAttribute("dependenciesTask",new DependenciesTask());

        return "addTask";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String createTask(@ModelAttribute("taskForm")Task task, Model model)
    {




        task.setEarlyFinish(-1);
        task.setEarlyStart(0);
        task.setCriticalCost(0);

        Iterable<Task> taskIterable = taskService.getAllTask();

        model.addAttribute("allTask", taskIterable);

/*
        Task dep = new Task();
        task.setTaskDependencies(dep);
*/


        taskService.addTask(task);

        return "addTask";
    }

    @RequestMapping(value = "/allTask", method = RequestMethod.GET)
    public String processViewTaskList (@ModelAttribute("allTask")Task task ,Model model){

        Iterable<Task> taskIterable = taskService.getAllTask();
        model.addAttribute("allTask",taskIterable);
        return "allTask";
    }

    @RequestMapping(value = "/task/delete/{taskId}", method = RequestMethod.GET)
    public String processDeleteTaskForm (Task task, @PathVariable String taskId,Model model){

        Long id = Long.decode(taskId);
        try {
            taskService.deleteTask(id);

        }catch (DataIntegrityViolationException e){

            Iterable<Task> taskIterable = taskService.getAllTask();
            model.addAttribute("allTask", taskIterable);
            model.addAttribute("DeleteError", new String("Removal of the current Task is impossible"));
            model.addAttribute("taskId", taskId);
            return "allTask";
        }
        Iterable<Task> taskIterable = taskService.getAllTask();
        model.addAttribute("allTask", taskIterable);

        return "allTask";
    }

    @RequestMapping(value = "/task/edit/{taskId}", method = RequestMethod.GET)
    public String processEditTaskForm(@PathVariable String taskId, Model model){
        Long id = Long.decode(taskId);

        Task editTask = taskService.findById(id);


        model.addAttribute("taskForm", editTask);


        return "addTask";
    }

    @RequestMapping(value = "/task/dependencies/{taskId}", method = RequestMethod.GET)
    public String processAddDependencies (@PathVariable String taskId,Model model, Task dep){

        Long id = Long.decode(taskId);

        Task editTask = taskService.findById(id);

        editTask.setTaskDependencies(dep);

        model.addAttribute("taskForm",editTask);

        return "addTask";
    }


}
