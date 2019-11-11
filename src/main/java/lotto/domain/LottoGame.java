package lotto.domain;


import java.util.List;

public class LottoGame {
    public static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";

    private Lottos lottos;

    public LottoGame(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        lottos = Lottos.generatedAuto(gameCount);
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = Lottos.of(lottos);
    }

    public LottoGame(int money, List<String> lottoStrings) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        int autoGameCount = gameCount - lottoStrings.size();
        lottos = Lottos.generatedAuto(autoGameCount);
        lottos.addAll(lottoStrings);
    }

    private int gameCount(int money) {
        return money / GAME_AMOUNT;
    }

    public int lottoSize() {
        return lottos.size();
    }

    public LottoResult result(WinningLotto winningLotto) {
        return lottos.result(winningLotto, gameMoney());
    }

    private int gameMoney() {
        return lottos.size() * GAME_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return lottos.unmodifiableLottos();
    }
}
