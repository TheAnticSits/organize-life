package org.launchcode.organizelife.Models.data;


import org.launchcode.organizelife.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
//    public void getUserName(String user);
}
