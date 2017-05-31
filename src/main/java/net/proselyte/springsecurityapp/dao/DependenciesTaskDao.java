package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.DependenciesTask;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Михаил on 11.05.2017.
 */
public interface DependenciesTaskDao extends JpaRepository<DependenciesTask ,Long> {

}
