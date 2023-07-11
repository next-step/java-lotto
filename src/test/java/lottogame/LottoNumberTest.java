package lottogame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("1이상 45이하의 숫자가 아니면 에러가 발생한다")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest()
    void 로또_번호_검증_실패_범위(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value))
            .withMessage("1이상 45이하의 숫자여야합니다");
    }

    @DisplayName("1이상 45이하의 숫자면 에러가 발생하지 않는다")
    @ValueSource(ints = {1, 45, 23})
    @ParameterizedTest()
    void 로또_번호_검증_성공(int value) {
        assertThatNoException()
            .isThrownBy(() -> new LottoNumber(value));
    }

    @DisplayName("자신과 같은 숫자라면 true를 반환한다")
    @Test
    void 숫자_비교_일치() {
        LottoNumber lottoNumber = new LottoNumber(1);
        LottoNumber another = new LottoNumber(1);

        assertThat(lottoNumber.isSame(another)).isTrue();
    }

    @DisplayName("자신과 다른 숫자라면 false를 반환한다")
    @Test
    void 숫자_비교_불일치() {
        LottoNumber lottoNumber = new LottoNumber(1);
        LottoNumber another = new LottoNumber(2);

        assertThat(lottoNumber.isSame(another)).isFalse();
    }

}
