package study.step4;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step4.domain.Amount;

public class AmountTest {
    @ParameterizedTest(name = "금액 유효성 테스트")
    @ValueSource(strings = {"900", "-1"})
    public void validAmount(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(input));
    }

    @ParameterizedTest(name = "수동 복권 수 유효성 테스트")
    @ValueSource(strings = {"-1", "3"})
    public void validManual(int input) {
        // given
        int amount = 2000;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(amount, input));
    }

    @ParameterizedTest(name = "복권 전체 구매 수 테스트")
    @CsvSource(value = {"1000:1", "2000:2", "150000: 150"}, delimiter = ':')
    public void totalCount(int input, int expected) {
        // given
        Amount amount = new Amount(input);
        // when & then
        assertThat(amount.totalCount()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "복권 수동 구매 수에 따른 자동 구매 수 테스트")
    @CsvSource(value = {"1:9", "5:5", "10:0"}, delimiter = ':')
    void manual(int input, int expected) {
        // given
        Amount amount = new Amount(10000, input);
        // when & then
        assertThat(amount.getAutoCount()).isEqualTo(expected);
    }
}
