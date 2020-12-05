package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StaticticTest {

    @Test
    @DisplayName("로또 결과 통계 테스트")
    void statisticTest() {
        FixedNumberGenerator fourWinningsGenerator = new FixedNumberGenerator();
        fourWinningsGenerator.setNumber("1,3,5,7,10,12");
        int money = 6500;
        Lottos lottos = Main.settingLottos(money, fourWinningsGenerator);

        ResultNumber.settingLottoResultNumber("1, 3, 5, 7, 10, 11");
        ResultNumber.settingLottoBonusNumber("12");

        lottos.checkResult();

        // 예상 결과값 계산
        int lottoCnt = money / 1000;
        int fourWinningReward = RewardBoard.getReward(2).getReward();
        int totalReward = lottoCnt * fourWinningReward;
        assertThat(Statistic.getMargin(money)).isEqualTo((float)totalReward/money);
    }
}
