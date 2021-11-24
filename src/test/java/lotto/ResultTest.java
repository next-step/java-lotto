package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {


    @Test
    @DisplayName(value = "로또번호가 2개 이하로 일치하는 경우, 보상금은 0원이다.")
    void matchLessThenThreeTest() {
        ResultLotto result = new ResultLotto(mockLottoMachine(1, 2, 3, 4, 5, 6).publish());

        assertThat(result.award(mockLottoMachine(40, 41, 42, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(result.award(mockLottoMachine(1, 41, 42, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(result.award(mockLottoMachine(1, 41, 2, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(Award.NON_MATCH.getReward()).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "로또번호가 3개 일치하면, 보상금은 5000원이다.")
    void matchOfThreeTest() {
        ResultLotto result = new ResultLotto(mockLottoMachine(1, 2, 3, 4, 5, 6).publish());

        assertThat(result.award(mockLottoMachine(1, 2, 3, 43, 44, 45).publish()))
            .isEqualTo(Award.MATCH_OF_THREE);

        assertThat(Award.MATCH_OF_THREE.getReward()).isEqualTo(5000);
    }

    @Test
    @DisplayName(value = "로또번호가 4개 일치하면, 보상금은 50,000원이다.")
    void matchOfFourTest() {
        ResultLotto result = new ResultLotto(mockLottoMachine(1, 2, 3, 4, 5, 6).publish());

        assertThat(result.award(mockLottoMachine(1, 2, 3, 4, 44, 45).publish()))
            .isEqualTo(Award.MATCH_OF_FOUR);

        assertThat(Award.MATCH_OF_FOUR.getReward()).isEqualTo(50_000);
    }

    @Test
    @DisplayName(value = "로또번호가 5개 일치하면, 보상금은 1,500,000원이다.")
    void matchOfFiveTest() {
        ResultLotto result = new ResultLotto(mockLottoMachine(1, 2, 3, 4, 5, 6).publish());

        assertThat(result.award(mockLottoMachine(1, 2, 3, 4, 5, 45).publish()))
            .isEqualTo(Award.MATCH_OF_FIVE);

        assertThat(Award.MATCH_OF_FIVE.getReward()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName(value = "로또번호가 6개 일치하면, 보상금은 2,000,000,000원이다.")
    void matchOfSixTest() {
        ResultLotto result = new ResultLotto(mockLottoMachine(1, 2, 3, 4, 5, 6).publish());

        assertThat(result.award(mockLottoMachine(1, 2, 3, 4, 5, 6).publish()))
            .isEqualTo(Award.MATCH_OF_SIX);

        assertThat(Award.MATCH_OF_SIX.getReward()).isEqualTo(2_000_000_000);
    }

    LottoMachine mockLottoMachine(int num1, int num2, int num3, int num4, int num5, int num6) {
        return () -> new LottoTicket(
            Arrays.asList(num1, num2, num3, num4, num5, num6));
    }


}
