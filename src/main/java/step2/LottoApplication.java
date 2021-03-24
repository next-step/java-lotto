package step2;

import step2.domain.Candidate;
import step2.domain.Lotto;
import step2.domain.Prize;
import step2.domain.Seed;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoApplication {

    public static final int lengthPerGame = 6;
    public static final int pricePerGame = 1000;

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        Seed seed = new Seed(InputView.getSeed());

        lotto.init(seed.amount() / pricePerGame, lengthPerGame);

        OutputView.printGameSize(lotto);
        OutputView.printGames(lotto);

        Prize prize = new Prize(InputView.getPrize());

        Candidate candidate = new Candidate(lotto.candidate(prize));
        OutputView.printStatistics();
        OutputView.printResult(candidate);

        OutputView.printProfit(prize.profit(candidate, seed));
    }
}
