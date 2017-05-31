package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.DependenciesTask;
import net.proselyte.springsecurityapp.model.Task;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Михаил on 07.05.2017.
 */
public interface TaskService {


   // public void setLatest();

//    public String[] toStringArray();

   // public boolean isDependent(Task t);

   // public  Task[] criticalPath(Set<Task> tasks);

   // public   void minCost(Set<Task> tasks);

    //public  void calculateEarly(HashSet<Task> initials);

   // public  void setEarly(Task initial);

  //  public  HashSet<Task> initials(Set<Task> tasks);

   // public  void maxCost(Set<Task> tasks);

 //   public  void print(Task[] tasks);

    void addTask(Task task);

    Iterable<Task> getAllTask();

     Task findById(Long id);

    void deleteTask(Long id);

    Task findByIdDepend(DependenciesTask dependenciesTask);



}
