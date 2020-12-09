package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumbersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public void validate(final List<Number> numbers) {
        if (numbers == null) {
            throw new InvalidNumbersException("null로 객체를 생성할 수 없습니다.");
        }
        if (numbers.isEmpty()) {
            throw new InvalidNumbersException("한 개 이상의 Number가 있어야만 합니다.");
        }
    }

    public Number sum() {
        return numbers.stream()
                .reduce(Number.of("0"), Number::plus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers thatNumbers = (Numbers) o;
        return this.numbers.equals(thatNumbers.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
