package Quiz6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Quiz6 {

    private Student[] stuArr;

    public Quiz6() {
        init();
    }

    public void quiz1() {
        Map<Boolean, List<Student>> map = new HashMap<Boolean, List<Student>>();

        Stream.of(stuArr)
                .filter(s -> s.getScore() < 150)
                .forEach(s -> map.merge(s.isMale(), new ArrayList<Student>(), (oldValue, newValue) -> {
                    oldValue.add(s);
                    return oldValue;
                }));
        map.keySet().forEach(k -> map.get(k).forEach(System.out::println));
    }

    public Map<Integer, Map<Integer, Integer>> quiz2() {
        Map<Integer, Map<Integer, Integer>> map;
        map = Stream.of(stuArr)
                .collect(groupingBy(Student::getHak, groupingBy(Student::getBan, summingInt(Student::getScore))));

        System.out.println(map);
        return map;
    }

    private void init() {
        stuArr = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };

    }

}
