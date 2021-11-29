package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import lotto.domain.Award;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.ResultLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {


    private int bonusNumber = 40;

    @Test
    @DisplayName(value = "로또번호가 2개 이하로 일치하는 경우, 보상금은 0원이다.")
    void matchLessThenThreeTest() {
        int num1 = 1;
        int num2 = 2;

        ResultLotto result = new ResultLotto(mockLottoMachine(num1, num2, 3, 4, 5, 6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(40, 41, 42, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(result.award(mockLottoMachine(num1, 41, 42, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(result.award(mockLottoMachine(num1, 41, num2, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(Award.NON_MATCH.getReward()).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "로또번호가 보너스번호를 포함한 3개가 일치하는 경우, 보상금은 0원이다.")
    void matchThreeWithTest() {
        int num1 = 1;
        int num2 = 2;

        ResultLotto result = new ResultLotto(mockLottoMachine(num1, num2, 3, 4, 5, 6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(num1, num2, bonusNumber, 43, 44, 45).publish()))
            .isEqualTo(Award.NON_MATCH);

        assertThat(Award.NON_MATCH.getReward()).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "로또번호가 3개 일치하면, 보상금은 5000원이다.")
    void matchOfThreeTest() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;

        ResultLotto result = new ResultLotto(mockLottoMachine(num1, num2, num3, 4, 5, 6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(num1, num2, num3, 43, 44, 45).publish()))
            .isEqualTo(Award.MATCH_OF_THREE);

        assertThat(Award.MATCH_OF_THREE.getReward()).isEqualTo(5000);
    }

    @Test
    @DisplayName(value = "로또번호가 4개 일치하면, 보상금은 50,000원이다.")
    void matchOfFourTest() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        ResultLotto result = new ResultLotto(
            mockLottoMachine(num1, num2, num3, num4, 5, 6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(num1, num2, num3, num4, 44, 45).publish()))
            .isEqualTo(Award.MATCH_OF_FOUR);

        assertThat(Award.MATCH_OF_FOUR.getReward()).isEqualTo(50_000);
    }

    @Test
    @DisplayName(value = "로또번호가 5개 일치하면, 보상금은 1,500,000원이다.")
    void matchOfFiveWithTest() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;
        ResultLotto result = new ResultLotto(
            mockLottoMachine(num1, num2, num3, num4, num5, 6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(num1, num2, num3, num4, num5, 45).publish()))
            .isEqualTo(Award.MATCH_OF_FIVE);

        assertThat(Award.MATCH_OF_FIVE.getReward()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName(value = "로또번호가 5개 및 보너스번호가 일치하면, 보상금은 30,000,000원이다.")
    void matchOfFiveWithBonusNumberTest() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;
        ResultLotto result = new ResultLotto(
            mockLottoMachine(num1, num2, num3, num4, num5, 45).publish(),
            bonusNumber);

        assertThat(
            result.award(mockLottoMachine(num1, num2, num3, num4, num5, bonusNumber).publish()))
            .isEqualTo(Award.MATCH_OF_FIVE_WITH_BONUS);

        assertThat(Award.MATCH_OF_FIVE_WITH_BONUS.getReward()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName(value = "로또번호가 6개 일치하면, 보상금은 2,000,000,000원이다.")
    void matchOfSixTest() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;
        int num6 = 6;

        ResultLotto result = new ResultLotto(
            mockLottoMachine(num1, num2, num3, num4, num5, num6).publish(),
            bonusNumber);

        assertThat(result.award(mockLottoMachine(num1, num2, num3, num4, num5, num6).publish()))
            .isEqualTo(Award.MATCH_OF_SIX);

        assertThat(Award.MATCH_OF_SIX.getReward()).isEqualTo(2_000_000_000);
    }

    LottoMachine mockLottoMachine(int num1, int num2, int num3, int num4, int num5, int num6) {
        return () -> new LottoTicket(
            Arrays.asList(num1, num2, num3, num4, num5, num6));
    }


}
