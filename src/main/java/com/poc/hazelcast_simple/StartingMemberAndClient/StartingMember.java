package com.poc.hazelcast_simple.StartingMemberAndClient;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.flakeidgen.FlakeIdGenerator;

import java.util.Map;
import java.util.Queue;


public class StartingMember {

    public static void main(String[] args) {
        Config config = new Config();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
//        FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator("newid");

        System.out.println("=========== Map ============");
        Map<Integer, String> mapCustomers = hazelcastInstance.getMap("customers");
        mapCustomers.put(1, "Ann");
        mapCustomers.put(2, "Joe");
        mapCustomers.put(3, "Pavlo");

        System.out.println("Customer with key 1: " + mapCustomers.get(1));
        System.out.println("Map Size:" + mapCustomers.size());

        System.out.println("=========== Queue ============");
        Queue<String> queueCustomers = hazelcastInstance.getQueue("customers");
        queueCustomers.offer("Archi");
        queueCustomers.offer("Tom");
        queueCustomers.offer("Jane");

        System.out.println("First customer: " + queueCustomers.poll());
        System.out.println("Second customer: " + queueCustomers.peek());
        System.out.println("Queue size: " + queueCustomers.size());

    }
}
