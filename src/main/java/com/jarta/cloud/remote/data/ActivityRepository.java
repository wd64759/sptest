package com.jarta.cloud.remote.data;

import org.springframework.data.repository.CrudRepository;

import com.jarta.cloud.data.remote.entities.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

}
