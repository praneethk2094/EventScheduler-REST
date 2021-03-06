package com.java.project.eventScheduler.EventService;

import com.java.project.eventScheduler.Entity.Event;
import com.java.project.eventScheduler.EventRepository.EventRepository;
import com.java.project.eventScheduler.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event getEvent(String id) {
        Event event;
        event = eventRepository.findOne(id);
        if (event == null) {
            try {
                throw new NotFoundException("No event with Id");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEventbyId(String id) {
        eventRepository.delete(id);
    }

    @Override
    public Event addEvent(Event event) {
        System.out.println(event);
        return eventRepository.save(event);
    }
}
