package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {
    @DisplayName("1 ~ 45 범위의 숫자를 가진 로또 숫자 객체를 생성할 수 있다.")
    @RepeatedTest(value = 45, name = "1 ~ 45 중 {currentRepetition} of {totalRepetitions}")
    void create(RepetitionInfo repetitionInfo) {
        int number = repetitionInfo.getCurrentRepetition();
        final LottoNumber expect = LottoNumber.valueOf(number);

        final LottoNumber actual = LottoNumber.valueOf(number);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("1 ~ 45 범위 외 숫자는 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidLottoNumber(int number) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> LottoNumber.valueOf(number)
        );
    }
}