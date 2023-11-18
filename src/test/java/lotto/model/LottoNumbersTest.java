package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6개가 아니면 에러")
    void test1() throws Exception {
        Set<PositiveNumber> numbers = new HashSet<>();
        numbers.add(new PositiveNumber(1));
        numbers.add(new PositiveNumber(2));
        numbers.add(new PositiveNumber(3));
        numbers.add(new PositiveNumber(4));
        numbers.add(new PositiveNumber(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복이면 에러")
    void test2() throws Exception {
        Set<PositiveNumber> numbers = new HashSet<>();
        numbers.add(new PositiveNumber(1));
        numbers.add(new PositiveNumber(2));
        numbers.add(new PositiveNumber(3));
        numbers.add(new PositiveNumber(4));
        numbers.add(new PositiveNumber(5));
        numbers.add(new PositiveNumber(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}