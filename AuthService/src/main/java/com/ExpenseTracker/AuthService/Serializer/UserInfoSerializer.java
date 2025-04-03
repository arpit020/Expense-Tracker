package com.ExpenseTracker.AuthService.Serializer;

import com.ExpenseTracker.AuthService.EventProducer.UserInfoEvent;
import com.ExpenseTracker.AuthService.Model.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;


import java.io.OutputStream;
import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoEvent>
{
    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    public byte[] serialize(String arg0, UserInfoEvent arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }
    @Override public void close() {
    }
}
