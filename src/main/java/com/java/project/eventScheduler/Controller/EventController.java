package com.java.project.eventScheduler.Controller;

import com.java.project.eventScheduler.Entity.Event;
import com.java.project.eventScheduler.EventService.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping(value = "/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Event getEvent(@PathVariable("id") String eventId) {
        return eventService.getEvent(eventId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Event addEvent(Event event) {
        return eventService.addEvent(event);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEvent(@PathVariable("id") String eventId) {
        eventService.deleteEvent(eventId);
        return "Deleted Successfully";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Event addOneEvents() {
        Event event = new Event("Notes", LocalDate.now(), LocalTime.now());
        return eventService.addEvent(event);
    }

}
