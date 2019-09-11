package org.launchcode.organizelife.Models.data;


import org.launchcode.organizelife.Models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
@Transactional
public interface TaskDao extends CrudRepository <Task, Integer>{
}
