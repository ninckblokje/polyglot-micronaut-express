/*
 * Copyright (c) 2020, ninckblokje
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ninckblokje.graalvm.pme.service;

import io.micronaut.test.annotation.MicronautTest;
import ninckblokje.graalvm.pme.domain.Event;
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
                LocalDate.parse("2020-01-01"),
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
                LocalDate.parse("2020-03-01"),
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
