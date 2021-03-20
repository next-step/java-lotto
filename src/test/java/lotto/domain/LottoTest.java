package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private List<Number> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        numbers.add(new Number(6));
        numbers.add(new Number(5));
        numbers.add(new Number(4));
        numbers.add(new Number(3));
        numbers.add(new Number(2));
        numbers.add(new Number(1));
    }

    @Test
    void 로또_숫자_개수_예외() {
        numbers.add(new Number(7));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(numbers);
                });
    }

    @Test
    void 오름차순_정렬() {
        assertThat(new Lotto(numbers).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
