package com.hazelcastcache.controller;

import com.hazelcastcache.cache.ItemCache;
import com.hazelcastcache.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemCache itemCache;
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId){
        System.out.println("RestController..");
        long start = System.currentTimeMillis();
        Item item = itemCache.getItem(itemId);
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) +" msec."));
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @GetMapping("/items")
    @ResponseBody
    public ResponseEntity<Item> getItems(){
        System.out.println("RestController..");
        long start = System.currentTimeMillis();
        List<Item> items = itemCache.getItems();
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) +" msec."));
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @PutMapping("/updateItem")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        if(item != null){
            itemCache.updateItem(item);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        itemCache.deleteItem(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
