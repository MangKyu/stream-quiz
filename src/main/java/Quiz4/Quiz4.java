package Quiz4;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        init();
    }

    private void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    public List<Transaction> quiz1() {
        List<Transaction> transactionList = transactions.stream()
                .filter(t -> t.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactionList.forEach(System.out::println);
        return transactionList;
    }

    public List<String> quiz2() {
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());

        cities.forEach(System.out::println);
        return cities;
    }

    public List<Trader> quiz3() {
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Seoul"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        traders.forEach(System.out::println);
        return traders;
    }

    public String quiz4() {
        String names = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(names);
        return names;
    }

    public boolean quiz5() {
        boolean isExist = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch(c -> c.equals("Busan"));
        System.out.println(isExist);
        return isExist;
    }

    public List<Integer> quiz6() {
        List<Integer> valueList = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Seoul"))
                .map(t -> t.getValue())
                .collect(Collectors.toList());
        valueList.forEach(System.out::println);
        return valueList;
    }

    public Integer[] quiz7() {
        Integer[] arr = new Integer[2];
        arr[0] = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);

        arr[1] = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElseThrow(RuntimeException::new).getValue();

        Arrays.stream(arr).forEach(System.out::println);
        return arr;
    }

}
