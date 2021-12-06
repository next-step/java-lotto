package step4.domain;

import step4.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("숫자 이외의 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"a", "한", "-", "/"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }

    @DisplayName("null or empty 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void notEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }

    @DisplayName("숫자의 범위는 1-45가 아니면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void NumberRangeTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }


    @DisplayName("getCachedLottoNumber() 는 미리 생성 된 로또 넘버를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 4, 5
            , 6, 7, 8, 9, 10
            , 11, 12, 13, 14, 15
            , 16, 17, 18, 19, 20
            , 21, 22, 23, 24, 25
            , 26, 27, 28, 29, 30
            , 31, 32, 33, 34, 35
            , 36, 37, 38, 39, 40
            , 41, 42, 43, 44, 45
    })
    void NumberCachedTest(int input) {
        assertThat(LottoNumber.of(input)).isEqualTo(LottoNumber.of(input));
        assertThat(LottoNumber.of(input)).isSameAs(LottoNumber.of(input));
    }

}
