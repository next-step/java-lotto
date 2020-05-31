package lottery;

import lottery.domain.LotteryNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryNumberTest {

    @DisplayName("LotteryNumber 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 3, 15})
    public void makeLotteryNumberObject(int lotteryNumber) {
        LotteryNumber lotteryNumberObject = LotteryNumber.from(lotteryNumber);

        assertThat(lotteryNumberObject.getLotteryNumber())
                .isEqualTo(lotteryNumber);
    }

    @DisplayName("LotteryNumber 객체 생성 실패 테스트(1 ~ 45 범위 외 숫자)")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void throwExceptionOnMakingLotteryNumberObject(int lotteryNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryNumber.from(lotteryNumber);
                });
    }
}
