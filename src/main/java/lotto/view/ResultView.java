package lotto.view;

import lotto.domain.Game;
import lotto.domain.Lotto;

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

    }
}
