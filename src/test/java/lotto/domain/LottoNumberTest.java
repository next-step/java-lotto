package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @DisplayName("1 ~ 45 범위의 숫자를 가진 로또 숫자 객체를 생성할 수 있다.")
    @RepeatedTest(value = 45, name = "1 ~ 45 중 {currentRepetition} of {totalRepetitions}")
    void create(RepetitionInfo repetitionInfo) {
        int number = repetitionInfo.getCurrentRepetition();
        final LottoNumber expect = new LottoNumber(number);

        final LottoNumber actual = new LottoNumber(number);

        assertThat(actual).isEqualTo(expect);
    }
}