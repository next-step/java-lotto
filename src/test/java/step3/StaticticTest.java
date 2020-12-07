package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.VO.Lottos;
import step3.VO.Money;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StaticticTest {

    @Test
    @DisplayName("로또 결과 통계 테스트")
    void statisticTest() {
        FixedNumberGenerator fourWinningsGenerator = new FixedNumberGenerator();
        fourWinningsGenerator.setNumber("1,3,5,7,10,12");

        int inputMoney = 6500;
        Money money = new Money(inputMoney);

        Main main = new Main();

        Lottos lottos = main.settingLottos(money, fourWinningsGenerator);
        Statistic statistic = new Statistic();
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber("1, 3, 5, 7, 10, 11");
        resultNumber.settingLottoBonusNumber("12");

        lottos.checkResult(statistic, resultNumber);

        // 예상 결과값 계산
        int lottoCnt = inputMoney / Money.lottoPrice;
        int fourWinningReward = RewardBoard.getReward(2).getReward();
        int totalReward = lottoCnt * fourWinningReward;
        assertThat(statistic.getMargin(money)).isEqualTo((float)totalReward/inputMoney);
    }
}
