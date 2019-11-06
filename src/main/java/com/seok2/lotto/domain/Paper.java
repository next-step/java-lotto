package com.seok2.lotto.domain;

import java.util.Objects;

public class Paper {

    private final String numbers;

    private Paper(String numbers) {
        this.numbers = numbers;
    }

    public static Paper of(String numbers) {
        return new Paper(numbers);
    }

    @Override
    public String toString() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paper paper = (Paper) o;
        return Objects.equals(numbers, paper.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
