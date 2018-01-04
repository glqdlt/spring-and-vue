package com.glqdlt.seminardemo2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {
    private static final String GREETING = "NIce to Meet You ";

    public List<SampleObject> getList() {

        List<SampleObject> list = new ArrayList<>();

        list.add(new SampleObject("Object-1"));
        list.add(new SampleObject("Object-2"));
        list.add(new SampleObject("Object-3"));

        return list;

    }

    public String greetingMessageBuilder(String message) {
        return GREETING + message;
    }


}
