package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호가 정상적이면 LottoNumbers 가 정상적으로 생성됩니다.")
    void test01() {
        assertThatNoException().isThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호의 범위가 정상적이면 에러가 발생합니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(-1, 2, 3, 4, 5, 6))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 46))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 번호의 개수는 6개이며, 아닐 경우 예외를 발생합니다.")
    void test03() {
        assertAll(
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6, 7))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또에 중복이 있을 경우 예외를 발생합니다.")
    void test04() {
        assertAll(
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 5))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumbers.ofTypeIntegers(1, 2, 2, 3, 3, 3))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

}