package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DependenciesTaskDao;
import net.proselyte.springsecurityapp.model.DependenciesTask;
import net.proselyte.springsecurityapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 */
@Service
public class DependenciesTaskImpl implements DependenciesTaskService {

    @Autowired
    private DependenciesTaskDao dependenciesTaskDao;


    @Override
    public void addDependenciesTask(DependenciesTask dependenciesTask) {
        dependenciesTaskDao.save(dependenciesTask);
    }

    @Override
    public Iterable<DependenciesTask> getAllDependensiesTask() {
        return dependenciesTaskDao.findAll();
    }

    @Override
    public void deleteDependenciesTask(Long id) {

        dependenciesTaskDao.delete(id);
    }


    /*@Override
    public boolean isDependent(Task t) {
        return false;
    }

    @Override
    public Task[] criticalPath() {
        return new Task[0];
    }

    @Override
    public void calculateEarly(HashSet<Task> initials) {

    }

    @Override
    public void setEarly(Task initial) {

    }

    @Override
    public HashSet<Task> initials() {
        return null;
    }

    @Override
    public void maxCost() {

    }

    @Override
    public void addDependenciesTask(DependenciesTask dependenciesTask) {


        dependenciesTaskDao.save(dependenciesTask);

    }

    @Override
    public void deleteDependenciesTask(Long id) {

    }



    public DependenciesTaskDao dependenciesTaskDao;

    public DependenciesTask dependenciesTask;

    public Task task;

    public TaskService taskService;



    @Override
    public boolean isDependent(Task t) {

        if (dependenciesTask.getDependencies().contains(t)) {
            return true;
        }

        // is t an indirect dependency

            if (dependenciesTask.getDependencies().contains(t)) {
                return true;
            }

        return false;
    }


    @Override
    public Task[] criticalPath() {
        HashSet<Task> completed = new HashSet<Task>();
        // tasks whose critical cost needs to be calculated
        HashSet<Task> remaining = new HashSet<Task>((Collection<? extends Task>) dependenciesTask);

        // Backflow algorithm
        // while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            boolean progress = false;

            // find a new task to calculate
            for (Iterator<Task> it = remaining.iterator(); it.hasNext();) {
                Task task = it.next();
                if (completed.containsAll(dependenciesTask.dependencies)) {
                    // all dependencies calculated, critical cost is max
                    // dependency
                    // critical cost, plus our cost
                    int critical = 0;
                    for (Task t : dependenciesTask.dependencies) {
                        if (t.criticalCost > critical) {
                            critical = t.criticalCost;
                        }
                    }
                    task.criticalCost = critical + task.cost;
                    // set task as calculated an remove
                    completed.add(task);
                    it.remove();
                    // note we are making progress
                    progress = true;
                }
            }
            // If we haven't made any progress then a cycle must exist in
            // the graph and we wont be able to calculate the critical path
            if (!progress)
                throw new RuntimeException("Cyclic dependency, algorithm stopped!");
        }

        // get the cost

        //Не понятно , будет ли работать тут
        maxCost();
        HashSet<Task> initialNodes = initials();
        calculateEarly(initialNodes);

        // get the tasks
        Task[] ret = completed.toArray(new Task[0]);
        // create a priority list

        Arrays.sort(ret, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        return ret;
    }




    @Override
    public void calculateEarly(HashSet<Task> initials) {
        for (Task initial : initials) {
            initial.earlyStart = 0;
            initial.earlyFinish = initial.cost;
            setEarly(initial);
        }

    }

    public void maxCost() {
        int max = -1;
        for (Task t : dependenciesTask.getDependencies()) {
            if (t.criticalCost > max)
                max = t.criticalCost;
        }
        maxCost = max;
        System.out.println("Critical path length (cost): " + maxCost);
        for (Task t : dependenciesTask.getDependencies()) {
            setEarly(t);
        }

    }


    /*
    @Override
    public void setEarly(Task initial) {
        int completionTime = initial.earlyFinish;
        for (Task t : initial.dependenciesTask.getDependencies()) {
            if (completionTime >= t.earlyStart) {
                t.earlyStart = completionTime;
                t.earlyFinish = completionTime + t.cost;
            }
            setEarly(t);
        }

    }


    @Override
    public HashSet<Task> initials() {
        HashSet<Task> remaining = new HashSet<Task>((Collection<? extends Task>) dependenciesTask);
        for (Task t : dependenciesTask.getDependencies()) {
            for (Task td : dependenciesTask.dependencies) {
                remaining.remove(td);
            }
        }

        System.out.print("Initial nodes: ");
        for (Task t : remaining)
            System.out.print(t.name + " ");
        System.out.print("\n\n");
        return remaining;
    }


*/

}
