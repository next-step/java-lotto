package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 숫자는")
class LottoNumberTest {
    public static final int MIN = 1;
    public static final int MAX = 45;

    @DisplayName("1 미만 or 45 초과 일 경우 오류 출력")
    @ParameterizedTest(name = "숫자 {0} 일 때")
    @ValueSource(ints = {MIN - 1, MAX + 1})
    void lottoNumberUnder1orAbove45ThrowsError(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 숫자는 1 이상, 45 이하의 정수입니다.");
    }

    @DisplayName("1이상 45이하일 경우 정상 생성")
    @ParameterizedTest(name = "숫자 {0} 일 때")
    @ValueSource(ints = {MIN, MAX})
    void lottoNumberIsFrom1to45(int number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @DisplayName("비교하는 수보다 작을 경우 음수 리턴")
    @Test
    void returnNegative() {
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(2)) < 0).isTrue();
    }
}
