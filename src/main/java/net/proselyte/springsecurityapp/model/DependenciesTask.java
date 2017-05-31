package net.proselyte.springsecurityapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Михаил on 07.05.2017.
 */
@Entity
@Table(name = "dependencies_task")
public class DependenciesTask   {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="task_id")
    private List<Task> dependencies;



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public List<Task> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Task> dependencies) {
        this.dependencies = dependencies;
    }



    public DependenciesTask(List<Task> dependencies) {

        for (Task t : dependencies) {
            this.dependencies.add(t);
        }

    }

    public DependenciesTask() {
    }
}
