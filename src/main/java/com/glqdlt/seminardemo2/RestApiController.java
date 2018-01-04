package com.glqdlt.seminardemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/")
@RestController
public class RestApiController {

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "greeting", method = RequestMethod.POST)
    public ResponseEntity<String> getList(@RequestBody Map<String,String> receiveData) {

        return new ResponseEntity<>(sampleService.greetingMessageBuilder(receiveData.get("message")), HttpStatus.OK);
    }


}
