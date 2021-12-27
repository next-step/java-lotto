package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RateTest {
    @ParameterizedTest
    @CsvSource({"5000,14000,0.35", "0,14000,0"})
    @DisplayName("dividend / divisor 한 값대로 expect를 value로 가지는 Rate 객체가 생성되는지 확인한다")
    void dividedAmount(long dividend, long divisor, double expect) {
        //given
        Amount dividendAmount = new Amount(dividend);
        Amount divisorAmount = new Amount(divisor);

        //when
        Rate resultAmount = dividendAmount.dividedAmount(divisorAmount);

        //then
        assertThat(resultAmount.equals(new Rate(expect))).isTrue();
    }
}