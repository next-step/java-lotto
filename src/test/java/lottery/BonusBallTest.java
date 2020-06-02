package lottery;

import lottery.domain.LotteryTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BonusBallTest {

    @DisplayName("보너스 볼 객체 번호가 당첨 번호와 중복될 시 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void throwExceptionWhenBonusBallDuplicatesWinnerTicket(int bonusBallNumber) {
        LotteryTicket lastWinnerTicket = LotteryTicket.from("1,2,3,4,5,6".split(","));
        assertThatCode(() -> {
            new BonusBall(bonusBallNumber, lastWinnerTicket);
        });
    }
}
