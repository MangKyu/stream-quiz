package com.mangkyu.stream.Quiz5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz5Test {

    private final Answer5 answer = new Answer5();
    private final Quiz5 quiz = new Quiz5();

    @Test
    void quiz1() {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

    @Test
    void quiz3() {
        assertThat(isCorrect(quiz.quiz3())).isTrue();
    }

    private boolean isCorrect(List<Integer> quiz) {
        List<Integer> answer = new ArrayList<>(quiz);
        Collections.sort(answer);
        return quiz.stream().distinct().count() == 6 && answer.equals(quiz);
    }

    @Test
    void quiz4() {
        assertThat(isEquals(quiz.quiz4(), answer.quiz4())).isTrue();
    }

    private boolean isEquals(List<Integer[]> quiz, List<Integer[]> answer) {
        if (quiz.size() != answer.size()) {
            return false;
        }

        for (int i = 0; i < answer.size(); i++) {
            if (!Arrays.deepEquals(quiz.get(i), answer.get(i))) {
                return false;
            }
        }
        return true;
    }

}