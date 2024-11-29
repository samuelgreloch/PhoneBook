package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
      this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        phonebook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {

        List<String> phones = phonebook.computeIfAbsent(name, k -> new ArrayList<>());
        phones.addAll(Arrays.asList(phoneNumbers));

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        List<String> phoneNumbers = phonebook.get(name);
        return phoneNumbers != null && phoneNumbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {

        return phonebook.getOrDefault(name, Collections.emptyList());
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
return null;
    }

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public List<String> getAllContactNames() {

        return new ArrayList<>(phonebook.keySet());
    }


    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}