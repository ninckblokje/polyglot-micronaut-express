package ninckblokje.graalvm.polyglot.service;

import ninckblokje.graalvm.polyglot.EmbeddedApplication;
import ninckblokje.graalvm.polyglot.repository.EventRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbeddedApplicationTest {

    @Test
    public void test() {
        EmbeddedApplication embeddedApplication = new EmbeddedApplication();
        embeddedApplication.runEmmbedded();

        EventService eventService = embeddedApplication.getBean(EventService.class);
        assertNotNull(eventService);

        EventRepository eventRepository = embeddedApplication.getBean(EventRepository.class);
        assertNotNull(eventRepository);
    }
}
