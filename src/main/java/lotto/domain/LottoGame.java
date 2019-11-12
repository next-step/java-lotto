package lotto.domain;


import java.util.List;

public class LottoGame {
    public static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";

    public static Lottos buyLotto(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        return Lottos.generatedAuto(gameCount);
    }

    public static Lottos buyLottoWithSelfNumbers(int money, List<String> lottoStrings) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        int autoGameCount = gameCount - lottoStrings.size();
        Lottos lottos = Lottos.generatedAuto(autoGameCount);
        lottos.addAll(lottoStrings);
        return lottos;
    }

    private static int gameCount(int money) {
        return money / GAME_AMOUNT;
    }
}
