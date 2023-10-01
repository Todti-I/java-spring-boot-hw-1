package ru.vedeshkin.hw1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CollectionsController {
    private ArrayList<String> arrayList = null;
    private HashMap<Integer, String> hashMap = null;

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam String value) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(value);
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (arrayList == null) {
            return "[]";
        }
        return arrayList.toString();
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam Integer key, @RequestParam String value) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(key, value);
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (hashMap == null) {
            return "{}";
        }
        return hashMap.toString();
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arraySize = arrayList == null ? 0 : arrayList.size();
        int mapSize = hashMap == null ? 0 : hashMap.size();
        return String.format("ArrayList = %s, HashMap = %s", arraySize, mapSize);
    }
}
