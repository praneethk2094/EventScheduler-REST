package com.java.project.eventScheduler.EventService;

import com.java.project.eventScheduler.Entity.Event;

import java.util.List;

public interface EventService {
    Event getEvent(String id);

    List<Event> getAllEvents();

    void deleteEventbyId(String id);

    Event addEvent(Event event);

}
