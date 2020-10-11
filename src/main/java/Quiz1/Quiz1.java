package Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz1 {

    public void quiz1() throws IOException {
        // https://jeong-pro.tistory.com/212

        // 취미별로 정씨성을 갖는 인원수를 구하라
        Map<String, Integer> result = new HashMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        List<String[]> csvLines = csvReader.readAll();

        csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue) -> newValue += oldValue));

        result.keySet().forEach(v -> System.out.println(v + ": " + result.get(v)));
    }

    public void quiz2() throws IOException {
        Map<String, Integer> result = new HashMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));

        csvReader.readNext();
        List<String[]> csvLines = csvReader.readAll();

        csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue) -> ++newValue));

        result.keySet().forEach(v -> System.out.println(v + ": " + result.get(v)));
    }

    private static final String target = "좋아";
    private static final int size = target.length();

    public void quiz3() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));

        csvReader.readNext();
        List<String[]> csvLines = csvReader.readAll();

        long count = csvLines.stream()
                .map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);
        System.out.println(count);
    }

    private int countContains(String src, int fromIndex) {
        int index = src.indexOf(target, fromIndex);
        if (index >= 0) {
            return 1 + countContains(src, index + size);
        }
        return 0;
    }

}
