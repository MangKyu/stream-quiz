package com.mangkyu.stream.Quiz1;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz1Test {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();

    @Test
    void quiz1() throws IOException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() throws IOException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

    @Test
    void quiz3() throws IOException {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
    }

}