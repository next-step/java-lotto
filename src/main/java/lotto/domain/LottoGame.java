package lotto.domain;


import java.util.List;

public class LottoGame {
    public static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";

    private UserLotto userLotto;

    public LottoGame(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        userLotto = UserLotto.generatedAuto(gameCount);
    }

    public LottoGame(List<Lotto> lottos) {
        userLotto = UserLotto.of(lottos);
    }

    public LottoGame(int money, String[] lottoStrings) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        int autoGameCount = gameCount - lottoStrings.length;
        userLotto = UserLotto.generatedAuto(autoGameCount);
        userLotto.addAll(lottoStrings);
    }

    private int gameCount(int money) {
        return money / GAME_AMOUNT;
    }

    public int lottoSize() {
        return userLotto.size();
    }

    public LottoResult result(WinningLotto winningLotto) {
        return userLotto.result(winningLotto, gameMoney());
    }

    private int gameMoney() {
        return userLotto.size() * GAME_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return userLotto.unmodifiableLottos();
    }
}
