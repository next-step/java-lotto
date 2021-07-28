package lotto.auto.model;

import java.util.List;
import java.util.Objects;

import static lotto.auto.context.ConstantContext.GAME_PRICE;

public final class GameAnalyzer {
    private final List<LottoGame> lottoGames;

    private GameAnalyzer(final List<LottoGame> lottoGames) {
        this.lottoGames = lottoGames;
    }

    public static GameAnalyzer from(final List<LottoGame> lottoGames) {
        Objects.requireNonNull(lottoGames);
        return new GameAnalyzer(lottoGames);
    }

    public int[] getMatchTable(final int[] numbers) {
        Objects.requireNonNull(numbers);
        int[] matchTable = new int[7];
        for (LottoGame lottoGame : lottoGames) {
            matchTable[getMatchCount(numbers, lottoGame)]++;
        }
        return matchTable;
    }

    private int getMatchCount(final int[] numbers, final LottoGame lottoGame) {
        int matchCount = 0;
        for (int number : numbers) {
            if (lottoGame.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateEarningsRate(final int[] matchTable) {
        Objects.requireNonNull(matchTable);
        double total = 0;
        for (int i = 3; i <= 6; i++) {
            int prizeMoney = Rank.findPrizeMoneyByMatchCount(i);
            int count = matchTable[i];
            total += prizeMoney * count;
        }

        if (total == 0) {
            return 0.00;
        }

        return total / (lottoGames.size() * GAME_PRICE);
    }
}
