package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.DependenciesTask;
import net.proselyte.springsecurityapp.model.Task;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Михаил on 11.05.2017.
 */
public interface DependenciesTaskService {

    //public void setLatest();

   // public String[] toStringArray();

   // public boolean isDependent(Task t);

   // public  Task[] criticalPath();



//    public  void calculateEarly(HashSet<Task> initials);

  //  public  void setEarly(Task initial);

    //public  HashSet<Task> initials();

    //public  void maxCost();

     void addDependenciesTask(DependenciesTask dependenciesTask);

     Iterable<DependenciesTask> getAllDependensiesTask();



     void deleteDependenciesTask(Long id);
}
