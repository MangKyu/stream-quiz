package Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map quiz1() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        WORDS.stream().map(w -> w.substring(0, 1)).forEach(prefix -> wordCountMap.merge(prefix, 1, (oldValue, newValue) -> (newValue += oldValue)));
        wordCountMap.keySet().forEach(k -> System.out.println(k + ": " + wordCountMap.get(k)));
        return wordCountMap;
    }

    public static String quiz2() {
        String result = WORDS.stream().filter(w -> w.length() > 1).map(String::toUpperCase).map(w -> w.substring(0, 1)).collect(Collectors.joining(" "));
        System.out.println(result);
        return result;
    }

}
