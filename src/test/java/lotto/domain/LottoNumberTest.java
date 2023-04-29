package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호의 범위는 1~45입니다.")
    void test01() {
        assertAll(
                () -> assertThatNoException()
                        .isThrownBy(() -> new LottoNumber(1)),
                () -> assertThatNoException()
                        .isThrownBy(() -> new LottoNumber(10)),
                () -> assertThatNoException()
                        .isThrownBy(() -> new LottoNumber(32)),
                () -> assertThatNoException()
                        .isThrownBy(() -> new LottoNumber(45))
        );
    }

    @Test
    @DisplayName("로또 번호가 1보다 작거나 45보다 큰경우 예외가 발생합니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(-1))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(0))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(46))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("LottoNumber 값이 같을 경우 동일하게 취급합니다.")
    void test03() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

}