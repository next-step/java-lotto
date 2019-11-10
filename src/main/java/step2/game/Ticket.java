package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {
    public static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private List<LottoGame> lottoGames;

    public Ticket(int amount) {
        lottoGames = new ArrayList<>();
        int lottoCount = buyLottoGames(amount);
        for (int count = 0; count < lottoCount; count++) {
            lottoGames.add(new LottoGame());
        }
    }

    public List<LottoGame> getLottoGames() {
        return Collections.unmodifiableList(lottoGames);
    }

    public int countGames() {
        return lottoGames.size();
    }

    private int buyLottoGames(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
        return amount / LOTTO_PRICE;
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
}
