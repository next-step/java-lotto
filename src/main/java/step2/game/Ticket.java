package step2.game;

import step2.analyze.WinningCount;
import step2.numbers.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {
    public static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private static final String MANUAL_AMOUNT_EXCEPTION = "구입하려는 금액을 초과합니다.";
    private Map<String, GameStrategy> games = new HashMap<>();

    public Ticket(int autoCount, List<String> manualNumbers) {
        games.put(AutoGames.STRATEGY, new AutoGames(autoCount));
        games.put(ManualGames.STRATEGY, new ManualGames(manualNumbers));
    }

    public static int verifyAutoCount(int amount, int manualCount) {
        int lottoCount = buyLottoGames(amount);
        if (manualCount > lottoCount) {
            throw new IllegalArgumentException(MANUAL_AMOUNT_EXCEPTION);
        }
        return lottoCount - manualCount;
    }

    private static int buyLottoGames(int amount) {
        verifyAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private static void verifyAmount(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }

    public int getCount(String strategy) {
        return games.get(strategy).size();
    }

    public String toString(String strategy, int index) {
        return games.get(strategy).toString(index);
    }

    public WinningCount checkWinningCount(WinningLotto winningLotto) {
        WinningCount winningCount = new WinningCount();
        winningCount.putAll(winningLotto.getWinningCount(games.get(AutoGames.STRATEGY)));
        winningCount.putAll(winningLotto.getWinningCount(games.get(ManualGames.STRATEGY)));
        return winningCount;
    }
}
