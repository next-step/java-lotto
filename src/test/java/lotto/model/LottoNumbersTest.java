package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6개가 아니면 에러")
    void test1() {
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(LottoNumber.of(1));
        numbers.add(LottoNumber.of(2));
        numbers.add(LottoNumber.of(3));
        numbers.add(LottoNumber.of(4));
        numbers.add(LottoNumber.of(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복이면 에러")
    void test2() {
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(LottoNumber.of(1));
        numbers.add(LottoNumber.of(2));
        numbers.add(LottoNumber.of(3));
        numbers.add(LottoNumber.of(4));
        numbers.add(LottoNumber.of(5));
        numbers.add(LottoNumber.of(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}