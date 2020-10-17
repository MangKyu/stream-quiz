package Quiz5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz5 {

    private static final String[] strArr = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
        int sum = Arrays.stream(strArr)
                .mapToInt(String::length)
                .sum();
        System.out.println(sum);
        return sum;
    }

    public int quiz2() {
        int length = Arrays.stream(strArr)
                .mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println(length);
        return length;
    }

    public List<Integer> quiz3() {
        List<Integer> integers = new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());

        integers.forEach(System.out::println);
        return integers;
    }

    public List<Integer[]> quiz4() {
        Stream<Integer> dies = IntStream.rangeClosed(1, 6).boxed();
        List<Integer[]> list = dies.flatMap(i -> IntStream.rangeClosed(1, 6).boxed().map(j -> new Integer[]{i, j}))
                .filter(arr -> arr[0] + arr[1] == 6).collect(Collectors.toList());

        list.forEach(a -> System.out.printf("[%d, %d]\n", a[0], a[1]));

        return list;


    }

}
