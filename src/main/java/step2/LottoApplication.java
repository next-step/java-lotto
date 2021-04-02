package step2;

import step2.domain.Lotto;
import step2.domain.Prize;
import step2.domain.Seed;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoApplication {

    public static final int LENGTH_PER_GAME = 6;
    public static final int PRICE_PER_GAME = 1000;

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        Seed seed = new Seed(InputView.getSeed());

        lotto.init(seed.amount(), PRICE_PER_GAME, LENGTH_PER_GAME);

        OutputView.printGameSize(lotto);
        OutputView.printGames(lotto);

        Prize prize = new Prize(InputView.getPrize(), InputView.getBonus());

        lotto.match(prize);
        OutputView.printStatistics();
        OutputView.printResult(lotto);

        OutputView.printProfit(prize.profit(lotto, seed));
    }
}
