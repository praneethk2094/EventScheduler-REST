package com.java.project.eventScheduler.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private String id;
    @Column
    private String notes;
    @Column
    private LocalDate date;
    @Column
    private LocalTime time;

    public Event() {
    }

    public Event(String notes, LocalDate date, LocalTime time) {
        this.notes = notes;
        this.date = date;
        this.time = time;
    }

}
