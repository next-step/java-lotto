package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    List<Integer> integers;
    Number[] numbers;

    @BeforeEach
    void beforeEach() {
        this.integers = IntStream
                .range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        this.numbers = this.integers
                .stream()
                .map(Number::of)
                .toArray(Number[]::new);
    }

    @Test
    @DisplayName("로또 구매 - 자동")
    void auto() {
        assertThat(Lotto.auto().getLotto()).hasSize(6).containsAnyOf(this.numbers);
    }

    @Test
    @DisplayName("로또 구매 - 수동")
    void manual() {
        List<Integer> integers = this.integers.subList(0, 6);
        List<Number> numbers = integers
                .stream()
                .map(Number::of)
                .collect(Collectors.toList());

        assertThat(Lotto.manual(integers).getLotto()).hasSize(6).containsAll(numbers);
    }
}
