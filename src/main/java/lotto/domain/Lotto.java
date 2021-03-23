package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;
    private List<LottoNumber> games;

    public Lotto(int money, LottoNumberGenerator lottoNumberGenerator) {
        if (money < PRICE) {
            throw new IllegalArgumentException();
        }

        this.games = new ArrayList<>();
        int numberOfGames = money / PRICE;
        while (numberOfGames-- > 0) {
            games.add(lottoNumberGenerator.numbers());
        }
    }

    public List<LottoNumber> games() {
        return this.games;
    }

    public Winners winners(WinningNumber winningNumber) {
        Winners winners = new Winners();

        for (LottoNumber game : games) {
            int countOfMatch = winningNumber.countOfMatch(game);
            boolean matchBonus = winningNumber.matchBonus(game);
            winners.increase(Rank.valueOf(countOfMatch, matchBonus));
        }
        return winners;
    }
}
