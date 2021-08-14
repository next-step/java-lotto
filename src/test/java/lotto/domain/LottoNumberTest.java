package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또숫자 생성 테스트")
class LottoNumberTest {

    @DisplayName("로또 넘버 생성")
    @ParameterizedTest(name = "VALUE : \"{0}\"")
    @ValueSource(ints = {1, 2, 44, 45})
    void constructLottoNumberTest(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isNotNull();
    }

    @Test
    @DisplayName("로또 넘버 같은 값 비교")
    void sameLottoNumberTest() {
        LottoNumber actual = new LottoNumber(LottoNumber.MIN_NUMBER);
        LottoNumber expected = new LottoNumber(LottoNumber.MIN_NUMBER);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또숫자가 최소값 보다 낮을 떄 예외처리")
    void lottoNumberLessThenMinimumException() {
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MIN_NUMBER - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be less than " + LottoNumber.MIN_NUMBER);
    }

    @Test
    @DisplayName("로또숫자가 최대값 보다 높을 떄 예외처리")
    void lottoNumberGreaterTHenMaximumException() {
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MAX_NUMBER + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be greater than " + LottoNumber.MAX_NUMBER);
    }
}