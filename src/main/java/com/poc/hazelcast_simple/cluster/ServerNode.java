package com.poc.hazelcast_simple.cluster;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
//import com.hazelcast.flakeidgen.FlakeIdGenerator;

import java.util.Map;

public class ServerNode {

    public static void main(String[] args) {
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
        Map<Long, String> map = hzInstance.getMap("datass");
        IdGenerator idGenerator = hzInstance.getIdGenerator("newidss");
//        FlakeIdGenerator idGenerator = hzInstance.getFlakeIdGenerator("newidss");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "message " + i);
        }
    }

}
