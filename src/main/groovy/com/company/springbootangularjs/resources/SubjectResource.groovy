package com.company.springbootangularjs.resources

import com.company.springbootangularjs.api.SaveResponse
import com.company.springbootangularjs.api.Subject
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.http.MediaType.POST
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@Slf4j
@RequestMapping('/subjects')
class SubjectResource extends BaseResource {

    @RequestMapping(value = '/{jobnumber}', method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation('Gets all the subjects for a job')
    List<Subject> sendDocumentsToDevice(@PathVariable String jobnumber) {
        log.info("Jobnumber: ${jobnumber}")

        List<Subject> subjects = []

        for (int x = 1; x < 10; x++) {
            Subject subject = new Subject()
            subject.image = "http://placeimg.com/250/300/any/${x}"
            subject.name = "Paul ${x}"
            subject.piecenumber = jobnumber
            subject.seq = "${x}"
            subject.redobgr = 0
            subjects << subject
        }
        return subjects
    }

    @RequestMapping(method = POST,
            consumes = [APPLICATION_JSON_VALUE],
            produces = [APPLICATION_JSON_VALUE])
    @ApiOperation('Accepts subjects to be saved; bgrflag is only data persisted')
    SaveResponse sendDocumentsToDevice(@RequestBody @Valid List<Subject> subjects) {
        log.info('Saving subjects')
        subjects.each {
            log.info("piecenum:${it.piecenumber} seq:${it.seq}  bgrflag:${it.redobgr}")
        }
        SaveResponse save = new SaveResponse()
        save.status = 'OK'
        return save
    }
}
