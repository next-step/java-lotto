package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @DisplayName("45보다 큰 수로 생성시 exception 발생")
    @Test
    void numberLargerThan45ThrowsException() {
        // given
        int number = 46;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumber.of(number));
    }

    @DisplayName("1보다 작은 수로 생성시 exception 발생")
    @Test
    void numberSmallerThan1ThrowsException() {
        // given
        int number = 0;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumber.of(number));
    }

    @DisplayName("number가 같으면 동일한 인스턴스 재사용")
    @Test
    void name() {
        // given & when
        LottoNumber lottoNumber1 = LottoNumber.of(22);
        LottoNumber lottoNumber2 = LottoNumber.of(22);

        // then
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}