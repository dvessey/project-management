package com.damon.pma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.damon.pma.entities.UserAccount;

@RepositoryRestResource(collectionResourceRel="apiuseraccounts", path="useraccounts")

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
