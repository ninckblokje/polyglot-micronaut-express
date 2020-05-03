package ninckblokje.graalvm.polyglot.service;

import io.micronaut.test.annotation.MicronautTest;
import ninckblokje.graalvm.polyglot.domain.Event;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class EventServiceTest {

    @Inject
    private EventService service;

    @Test
    public void test() {
        Event event1 = service.createNewEvent(
                "event1",
                "junit",
                "2020-01-01",
                7
        );
        assertNotNull(event1.getId());
        assertEquals("event1", event1.getName());
        assertEquals("junit", event1.getOrganizer());
        assertEquals(LocalDate.of(2020, 01, 01), event1.getDate());
        assertEquals(7, event1.getRating());

        Event event2 = service.createNewEvent(
                "event2",
                "junit",
                "2020-03-01",
                4
        );
        assertNotNull(event2.getId());
        assertEquals("event2", event2.getName());
        assertEquals("junit", event2.getOrganizer());
        assertEquals(LocalDate.of(2020, 03, 01), event2.getDate());
        assertEquals(4, event2.getRating());

        List<Event> events = service.getAllEvents();
        assertNotNull(events);
        assertEquals(2, events.size());
    }
}
