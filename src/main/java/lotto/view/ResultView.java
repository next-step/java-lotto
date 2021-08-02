package lotto.view;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Reward;

public class ResultView {

    public static void resultLottoCount(Game game) {
        System.out.println(game.getLottoSize() + "개를 구매했습니다.");
    }

    public static void resultLottoNumbers(Game game) {
        for (Lotto lotto : game.getLottoList()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void resultLottoReward(Game game) {
        for (Reward reward : Reward.values()) {
            System.out.println(
                    reward.getRightNumberCount() + "개 일치 ("
                            + reward.getMoney() + "원)- " +
                            game.getNumberOfRightLotto(reward.getRightNumberCount()) + "개");
        }
    }
}
