package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private List<LottoGame> lottoGames;

    public Ticket(int amount) {
        int lottoCount = buyLottoGames(amount);

        lottoGames = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottoGames.add(new LottoGame());
        }
    }

    public int countGames() {
        return lottoGames.size();
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
        for (LottoGame lottoGame : lottoGames) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
        return winningCount;
    }

    public String toStringLottoNumbers(int index) {
        return lottoGames.get(index).toString();
    }

}
