package com.mangkyu.stream.Quiz4;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        return Collections.emptyList();
    }

    public List<String> quiz2() {
        return Collections.emptyList();
    }

    public List<Trader> quiz3() {
        return Collections.emptyList();
    }

    public String quiz4() {
        return null;
    }

    public boolean quiz5() {
        return false;
    }

    public List<Integer> quiz6() {
        return Collections.emptyList();
    }

    public Integer[] quiz7() {
        return new Integer[]{0, 0};
    }

}
