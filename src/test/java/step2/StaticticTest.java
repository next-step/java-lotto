package step2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StaticticTest {

    @Test
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

        for (Lotto lotto : lottos.lottoList) {
            Statistic.recordResult(lotto.checkReward(result));
        }

        int lottoCnt = money/1000;
        int fourWinningReward = Statistic.rewardList[1];
        int totalReward = lottoCnt*fourWinningReward;
        assertThat(Statistic.getMargin(money)).isEqualTo((float)totalReward/money);
    }
}
