package com.poc.hazelcast_simple.StartingMemberAndClient;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Map;

public class StartingClient {
    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        GroupConfig groupConfig = clientConfig.getGroupConfig();
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");
        HazelcastInstance hzClient = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Integer, String> map = hzClient.getMap("customers");

        System.out.println("Map size: " + map.size());
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(String.format("Key: %d, Value: %s ", entry.getKey(), entry.getValue()));
        }

    }
}
