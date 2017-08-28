package com.java.project.eventScheduler.EventRepository;

import com.java.project.eventScheduler.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    List<Event> findAll();
}
