package com.mangkyu.stream.Quiz6;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Answer6 {

    private Student[] stuArr;

    public Answer6() {
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

    public Map<Boolean, List<Student>> quiz1() {
        return Arrays.stream(stuArr)
                .filter(s -> s.getScore() < 150)
                .collect(groupingBy(Student::isMale));
    }

    public Map<Integer, Map<Integer, Integer>> quiz2() {
        return Stream.of(stuArr)
                .collect(groupingBy(Student::getHak, groupingBy(Student::getBan, summingInt(Student::getScore))));
    }

}
