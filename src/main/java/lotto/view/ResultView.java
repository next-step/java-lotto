package lotto.view;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void resultLottoCount(Game game) {
        System.out.println(game.getLottos().size() + "개를 구매했습니다.");
    }

    public static void resultLottoNumbers(Game game) {
        for (Lotto lotto : game.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void resultLottoReward(Game game) {
        List<Reward> rewardForPrint = Arrays.stream(Reward.values())
                .filter(reward -> reward != Reward.NONE)
                .collect(Collectors.toList());
        for (Reward reward : rewardForPrint) {
            System.out.println(
                    reward.getSameNumberCount() + "개 일치 (" + reward.getMoney() + "원)- " +
                            game.countReward(reward) + "개");
        }
    }

    public static void getYield(Game game) {
        System.out.println("총 수익률은 " + game.getYield() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
