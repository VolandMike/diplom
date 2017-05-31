package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Михаил on 07.05.2017.
 */
public interface TaskDao extends JpaRepository<Task,Long> {
}
