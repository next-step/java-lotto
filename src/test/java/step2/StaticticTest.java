package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StaticticTest {

    @Test
    @DisplayName("로또 결과 통계 테스트")
    void statisticTest() {
        FixedNumberGenerator fourWinningsGenerator = new FixedNumberGenerator();
        fourWinningsGenerator.setNumber("1,3,5,7,10,12");
        int money = 6500;
        String resultInput = "1, 3, 5, 7, 9, 11";

        Lottos lottos = Main.settingLottos(money, fourWinningsGenerator);

        Main.checkResult(lottos, resultInput);

        Statistic.recordResult(lottos);

        // 예상 결과값 계산
        int lottoCnt = money / 1000;
        int fourWinningReward = RewardBoard.getReward(4).getReward();
        int totalReward = lottoCnt * fourWinningReward;
        assertThat(Statistic.getMargin(money)).isEqualTo((float)totalReward/money);
    }
}
