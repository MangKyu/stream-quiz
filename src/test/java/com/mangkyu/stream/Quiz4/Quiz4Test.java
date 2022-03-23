package com.mangkyu.stream.Quiz4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz4Test {

    private final Answer4 answer = new Answer4();
    private final Quiz4 quiz = new Quiz4();

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
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
    }

    @Test
    void quiz4() {
        assertThat(quiz.quiz4()).isEqualTo(answer.quiz4());
    }

    @Test
    void quiz5() {
        assertThat(quiz.quiz5()).isEqualTo(answer.quiz5());
    }

    @Test
    void quiz6() {
        assertThat(quiz.quiz6()).isEqualTo(answer.quiz6());
    }

    @Test
    void quiz7() {
        assertThat(quiz.quiz7()).isEqualTo(answer.quiz7());
    }

}