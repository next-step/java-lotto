package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @ParameterizedTest
    @CsvSource({"5, true", "45, true", "10, false", "30, false"})
    @DisplayName("로또 번호들에 보너스볼이 일치하는게 있는지 확인한다.")
    void match_test(int bonusNumber, boolean expectedMatch) {
        //given
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 3, 4, 5, 45));
        BonusBall bonusBall = new BonusBall(bonusNumber);

        //when
        boolean match = bonusBall.match(lotteryNumbers);

        assertThat(match).isEqualTo(expectedMatch);
    }
}
