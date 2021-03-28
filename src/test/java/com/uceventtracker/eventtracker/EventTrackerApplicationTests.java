package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EventTrackerApplicationTests {
    private List<Event> allEvents;

    @Autowired
    private IEventService eventService;
    private Event event;

    @Test
    void checkEventData(){
        givenEventDataIsAvailable();
        whenEventIsSearchedWithId();
        thenViewEventData();
    }

    @Test
    void fetchAllEvents(){
        givenEventDataIsAvailable();
        whenEventDataIsLoaded();
        thenDisplayListOfEvents();
    }

    @Test
    void readRSSEventsFeed(){
        allEvents = eventService.fetchRssEvents();

        for(Event e : allEvents){
            System.out.println(e.getTitle());
        }
    }

    private void givenEventDataIsAvailable() {
    }

    private void whenEventIsSearchedWithId() {
        event = eventService.fetchEventById(1);
    }

    private void thenViewEventData() {
        System.out.println(event.getTitle());
        System.out.println(event.getLocation());
        System.out.println(event.getStartTime());
        System.out.println(event.getEndTime());
        System.out.println(event.getDescription());
        System.out.println(event.getHost());
    }

    private void whenEventDataIsLoaded() {
    }

    private void thenDisplayListOfEvents() {
        allEvents = eventService.fetchAllEvents();
    }
}
