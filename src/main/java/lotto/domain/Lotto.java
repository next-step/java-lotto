package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoGame> games;

    public Lotto(int money, LottoNumberGenerator lottoNumberGenerator) {
        this(money, null, lottoNumberGenerator);
    }

    public Lotto(int money, List<LottoGame> manualLottoGame, LottoNumberGenerator lottoNumberGenerator) {
        if (money < LottoRule.price()) {
            throw new IllegalArgumentException("최소 구매 금액은 1000원입니다.");
        }

        if (manualLottoGame == null) {
            manualLottoGame = new ArrayList<>();
        }

        initLottoGame(money, manualLottoGame, lottoNumberGenerator);
    }

    public List<LottoGame> games() {
        return this.games;
    }

    public Winners winners(WinningNumber winningNumber) {
        Winners winners = new Winners();

        for (LottoGame game : games) {
            winners.increase(winningNumber.rank(game));
        }
        return winners;
    }

    private void initLottoGame(int money, List<LottoGame> manualLottoGame, LottoNumberGenerator lottoNumberGenerator) {
        this.games = new ArrayList<>();

        appendManualGames(manualLottoGame);
        appendGeneratedGames(money, manualLottoGame.size(), lottoNumberGenerator);
    }

    private void appendManualGames(List<LottoGame> manualLottoGame) {
        this.games.addAll(manualLottoGame);
    }

    private void appendGeneratedGames(int money, int numberOfManualGames, LottoNumberGenerator lottoNumberGenerator) {
        int numberOfGames = numberOfGeneratedGames(money, numberOfManualGames);
        while (numberOfGames-- > 0) {
            games.add(lottoNumberGenerator.numbers());
        }
    }

    private int numberOfGeneratedGames(int money, int numberOfManualGames) {
        int numberOfGames = money / LottoRule.price() - numberOfManualGames;
        if (numberOfGames < 0) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
        return numberOfGames;
    }
}
