package Quiz3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz3 {

    private static List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static List<Integer> numbers2 = Arrays.asList(3, 4);

    public List<Integer[]> quiz1() {
        //List integers = numbers1.stream().map(n -> numbers2.stream().map(m -> new Integer[]{n, m})).collect(Collectors.toList());
        List<Integer[]> integers = numbers1.stream().flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m})).collect(Collectors.toList());
        String result = integers.stream().map(a -> "(" + a[0] + ", " + a[1] + ")").collect(Collectors.joining("\n"));
        System.out.println(result);
        return integers;
    }

    public Integer quiz2() {
        int maxValue = numbers1.stream().flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m})).mapToInt(a -> Integer.sum(a[0], a[1])).max().getAsInt();
        System.out.println(maxValue);
        return maxValue;
    }

}
