package net.proselyte.springsecurityapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static int maxCost;
    @Column(name = "task_cost")
    private int cost;
    // the cost of the task along the critical path
    @Column(name = "task_criticalCost")
    private int criticalCost;
    // a name for the task for printing
    @Column(name = "task_name")
    private String name;
    // the earliest start
    @Column(name = "task_earlyStart")
    private int earlyStart;
    // the earliest finish
    @Column(name = "task_earlyFinish")
    private int earlyFinish;
    // the latest start
    @Column(name = "task_latestStart")
    private int latestStart;
    // the latest finish
    @Column(name = "task_latestFinish")
    private int latestFinish;



    // the tasks on which this task is dependant

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="dependenciesTask")
    private Task taskDependencies;

    @OneToMany(mappedBy="taskDependencies")
    private Set<Task> dependencies = new HashSet<Task>();

    public Task getTaskDependencies() {
        return taskDependencies;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", cost=" + cost +
                ", criticalCost=" + criticalCost +
                ", name='" + name + '\'' +
                ", earlyStart=" + earlyStart +
                ", earlyFinish=" + earlyFinish +
                ", latestStart=" + latestStart +
                ", latestFinish=" + latestFinish +
                ", taskDependencies=" + taskDependencies +
                ", dependencies=" + dependencies +
                '}';
    }

    public void setTaskDependencies(Task taskDependencies) {
        this.taskDependencies = taskDependencies;
    }

    public Set<Task> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Task> dependencies) {
        this.dependencies = dependencies;
    }

    public Task(String name, int cost, Task taskDependencies) {
        this.name = name;
        this.cost = cost;
        this.earlyFinish = -1;
        this.earlyStart = 0;
        this.criticalCost = 0;
        this.latestStart = 0;
        this.latestFinish = 0;
        this.taskDependencies = taskDependencies;


    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCriticalCost() {
        return criticalCost;
    }

    public void setCriticalCost(int criticalCost) {
        this.criticalCost = criticalCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEarlyStart() {
        return earlyStart;
    }

    public void setEarlyStart(int earlyStart) {
        this.earlyStart = earlyStart;
    }

    public int getEarlyFinish() {
        return earlyFinish;
    }

    public void setEarlyFinish(int earlyFinish) {
        this.earlyFinish = earlyFinish;
    }

    public int getLatestStart() {
        return latestStart;
    }

    public void setLatestStart(int latestStart) {
        this.latestStart = latestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }






/*
    public boolean isDependent(Task t) {
        if (dependencies.contains(t)) {
            return true;
        }
        // is t an indirect dependency
        for (Task dep : dependencies) {
            if (dep.isDependent(t)) {
                return true;
            }
        }
        return false;
    }

    public void setLatest() {
        latestStart = maxCost - criticalCost;
        latestFinish = latestStart + cost;
    }
    */
}

