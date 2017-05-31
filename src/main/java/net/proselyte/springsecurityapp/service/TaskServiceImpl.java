package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DependenciesTaskDao;
import net.proselyte.springsecurityapp.dao.TaskDao;
import net.proselyte.springsecurityapp.model.DependenciesTask;
import net.proselyte.springsecurityapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Михаил on 07.05.2017.
 */
@Service
public class TaskServiceImpl implements TaskService {



    @Autowired
    private TaskDao taskDao;

    @Autowired
    private DependenciesTaskDao dependenciesTaskDao;
    public volatile int maxCost;

/*
    @Override
    public void setLatest() {

        int es = maxCost - task.getCriticalCost();
        int lf = task.getLatestStart() + task.getCost();

        task.setLatestFinish(lf);
        task.setEarlyStart(es);

    }









   @Override
    public boolean isDependent(Task t) {

        /*if (task.getDependencies().contains(t)) {
            return true;
        }

        // is t an indirect dependency
        for (Task dep : task.getDependencies()) {
            if (dep.getDependencies().contains(t)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Task[] criticalPath(Set<Task> tasks) {
        HashSet<Task> completed = new HashSet<Task>();
        // tasks whose critical cost needs to be calculated
        HashSet<Task> remaining = new HashSet<Task>(tasks);

        // Backflow algorithm
        // while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            boolean progress = false;

            // find a new task to calculate
            for (Iterator<Task> it = remaining.iterator(); it.hasNext();) {
                Task task = it.next();
                if (completed.containsAll(task.dependencies)) {
                    // all dependencies calculated, critical cost is max
                    // dependency
                    // critical cost, plus our cost
                    int critical = 0;
                    for (Task t : task.dependencies) {
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
        maxCost(tasks);
        HashSet<Task> initialNodes = initials(tasks);
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
    public void minCost(Set<Task> tasks) {
        int max = 9999;
        for (Task t : tasks) {
            if (t.criticalCost < max)
                max = t.criticalCost;
        }
        maxCost = max;
        System.out.println("Critical path length (cost): " + maxCost);
        for (Task t : tasks) {
            t.;
        }

    }

    @Override
    public void calculateEarly(HashSet<Task> initials) {
        for (Task initial : initials) {
            initial.earlyStart = 0;
            initial.earlyFinish = initial.cost;
            setEarly(initial);
        }

    }



    @Override
    public HashSet<Task> initials(Set<Task> tasks) {
        HashSet<Task> remaining = new HashSet<Task>(tasks);
        for (Task t : tasks) {
            for (Task td : t.dependencies) {
                remaining.remove(td);
            }
        }

        System.out.print("Initial nodes: ");
        for (Task t : remaining)
            System.out.print(t.name + " ");
        System.out.print("\n\n");
        return remaining;
    }

    @Override
    public void maxCost(Set<Task> tasks) {
        int max = -1;
        for (Task t : tasks) {
            if (t.criticalCost > max)
                max = t.criticalCost;
        }
        maxCost = max;
        System.out.println("Critical path length (cost): " + maxCost);
        for (Task t : tasks) {
            t.setLatest();
        }

    }

    @Override
    public void print(Task[] tasks) {

    }
    */

    @Override
    public void addTask(Task task) {


        taskDao.save(task);
    }

    @Override
    public Iterable<Task> getAllTask() {


        return taskDao.findAll();

    }

    @Override
    public Task findById(Long id) {

        return  taskDao.findOne(id);
    }


    @Override
    public void deleteTask(Long id) {

        taskDao.delete(id);

    }

    @Override
    public Task findByIdDepend(DependenciesTask dependenciesTask) {







        return null;
    }


}
