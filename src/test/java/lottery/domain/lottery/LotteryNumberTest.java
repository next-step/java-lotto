package lottery.domain.lottery;

import lottery.domain.lottery.LotteryNumber;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteryNumberTest {

    @ParameterizedTest(name = "유효하지 않은 로또 숫자 생성 | {arguments}")
    @CsvSource(value = {"-3|-3", "0|0", "46|46"}, delimiter = '|')
    public void invalidLotteryNumber(int number, int invalidNumber) {
        // given
        String message = LotteryNumber.INVALID_NUMBER + invalidNumber;

        // when
        ThrowingCallable throwingCallable = () -> new LotteryNumber(number);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "유효한 로또 숫자 생성 | {arguments}")
    @CsvSource(value = {"1|1", "25|25", "35|35"}, delimiter = '|')
    public void validLotteryNumber(int number, int validNumber) {
        // given
        LotteryNumber expectedLotteryNumber = new LotteryNumber(validNumber);

        // when
        LotteryNumber lotteryNumber = new LotteryNumber(number);

        // then
        assertThat(lotteryNumber).isEqualTo(expectedLotteryNumber);
    }

}