package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer2 {

    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {
        return WORDS.stream()
                .map(w -> w.substring(0, 1))
                .collect(Collectors.toMap(
                        prefix -> prefix, prefix -> 1,
                        (oldValue, newValue) -> (newValue += oldValue)));
    }

    public String quiz2() {
        return WORDS.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));
    }

}
