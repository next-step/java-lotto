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
        Generator fourWinningsGenerator = new FixedNumberGenerator();
        fourWinningsGenerator.setNumber("1,3,5,7,10,12");

        String resultInput = "1, 3, 5, 7, 9, 11";

        List<Integer> result = new ArrayList<>();

        for (String i : resultInput.split(", ")) {
            result.add(Integer.parseInt(i));
        }

        int money = 6500;
        Lottos lottos = new Lottos(money, fourWinningsGenerator);
        lottos.checkResult(result);

        int lottoCnt = money/1000;
        int fourWinningReward = RewardBoard.getReward(4).getReward();
        int totalReward = lottoCnt*fourWinningReward;
        assertThat(Statistic.getMargin(money)).isEqualTo((float)totalReward/money);
    }
}
