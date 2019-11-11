package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private static final String MANUAL_AMOUNT_EXCEPTION = "구입하려는 금액을 초과합니다.";
    private List<LottoGame> autoGames;
    private List<LottoGame> manualGames;


    public Ticket(int amount) {
        int lottoCount = buyLottoGames(amount);

        autoGames = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            autoGames.add(new AutoGame());
        }
    }

    public Ticket(int amount, int manualCount) {
        int lottoCount = buyLottoGames(amount);
        if (manualCount > lottoCount) {
            throw new IllegalArgumentException(MANUAL_AMOUNT_EXCEPTION);
        }
        autoGames = new ArrayList<>();
        for (int count = 0; count < lottoCount - manualCount; count++) {
            autoGames.add(new AutoGame());
        }
        manualGames = new ArrayList<>();
    }

    public void buyManuals(List<String> manualNumbers) {
        for (String manualNumber : manualNumbers) {
            manualGames.add(new ManualGame(manualNumber));
        }
    }

    public int getAutoCount() {
        return autoGames.size();
    }

    public int getManualCount() {
        return manualGames.size();
    }

    private int buyLottoGames(int amount) {
        verifyAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void verifyAmount(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }

    public WinningCount checkWinningCount(WinningLotto winningLotto) {
        WinningCount winningCount = new WinningCount();
        for (LottoGame lottoGame : autoGames) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
        for (LottoGame lottoGame : manualGames) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
        return winningCount;
    }

    public String toStringAutoNumbers(int index) {
        return autoGames.get(index).toString();
    }

    public String toStringManualNumbers(int index) {
        return manualGames.get(index).toString();
    }
}
