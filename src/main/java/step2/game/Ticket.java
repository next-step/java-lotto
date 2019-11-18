package step2.game;

import step2.analyze.WinningCount;
import step2.numbers.WinningLotto;

import java.util.List;

public class Ticket {
    public static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private static final String MANUAL_AMOUNT_EXCEPTION = "구입하려는 금액을 초과합니다.";
    private GameStrategy autoGames;
    private GameStrategy manualGames;

    public Ticket(int autoCount, List<String> manualNumbers) {
        autoGames = new AutoGames(autoCount);
        manualGames = new ManualGames(manualNumbers);
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

    public int getAutoCount() {
        return getCount(autoGames);
    }

    public int getManualCount() {
        return getCount(manualGames);
    }

    private int getCount(GameStrategy game) {
        return game.size();
    }

    public String toStringAutoNumbers(int index) {
        return toString(autoGames, index);
    }

    public String toStringManualNumbers(int index) {
        return toString(manualGames, index);
    }

    private String toString(GameStrategy game, int index) {
        return game.toString(index);
    }

    public WinningCount checkWinningCount(WinningLotto winningLotto) {
        WinningCount winningCount = new WinningCount();
        winningCount.putAll(winningLotto.getWinningCount(autoGames));
        winningCount.putAll(winningLotto.getWinningCount(manualGames));
        return winningCount;
    }
}
