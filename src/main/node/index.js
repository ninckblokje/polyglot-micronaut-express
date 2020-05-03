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

const port = 3000

const eventService = require('./polyglot/PolyglotEventService')

const express = require('express')
const app = express()

const multer = require('multer')
const upload = multer()

app.set('view engine', 'pug')

app.get('/', (req, res) => res.redirect("/events"))
app.get('/events', (req, res) => res.render('events', { events: eventService.getAllEvents() }))
app.get('/events/new', (req, res) => res.render('newEvent', {  }))

app.post('/events/new', upload.none(), (req, res) => {
    eventService.createNewEvent(
        req.body.eventName,
        req.body.eventOrganizer,
        req.body.eventDate,
        req.body.eventRating
    )
    res.redirect("/events")
})

app.listen(port, () => console.log(`polyglot-micronaut-express listening at http://localhost:${port}`))
