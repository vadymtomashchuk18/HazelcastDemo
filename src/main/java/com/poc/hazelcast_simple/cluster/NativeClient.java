package com.poc.hazelcast_simple.cluster;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Map.Entry;


public class NativeClient {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        GroupConfig groupConfig = clientConfig.getGroupConfig();
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, String> map = hazelcastInstanceClient.getMap("datass");
        //operations on a map without being a member of the cluster
        for (Entry<Long, String> entry : map.entrySet()) {
            System.out.println(String.format("Key: %d, Value: %s ", entry.getKey(), entry.getValue()));
        }

    }
}
