package controller;

import domain.Lotto;
import domain.Lottos;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.StringUtils.parseNumbers;

public class LottoGame {
    public static final int LOTTO_STARTING_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int FIFTH_PRIZE_MATCHING_NUMBER = 3;
    public static final int FOURTH_PRIZE_MATCHING_NUMBER = 4;
    public static final int THIRD_PRIZE_MATCHING_NUMBER = 5;
    public static final int FIRST_PRIZE_MATCHING_NUMBER = 6;
    public static final int PRICE_OF_LOTTO = 1_000;
    public static final int FIFTH_PRIZE_REWARD = 5_000;
    public static final int FOURTH_PRIZE_REWARD = 50_000;
    public static final int THIRD_PRIZE_REWARD = 1_500_000;
    public static final int FIRST_PRIZE_REWARD = 2_000_000_000;
    public static final int STARTING_INDEX_LOTTO = 0;
    public static final int LAST_INDEX_LOTTO = 6;
    public static final int STARTING_INDEX_LOTTOS = 0;

    private static final List<Integer> LOTTO_NUMBERS =
            IntStream.rangeClosed(LOTTO_STARTING_NUMBER, LOTTO_LAST_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private LottoGame() {

    }

    public static void run() {
        InputView inputView = new ConsoleInputView();
        inputView.showPurchaseAmountInputMessage();
        int purchaseAmount = inputView.extractPurchaseAmount();

        OutputView outputView = new ConsoleOutputView();
        int totalNumberOfLottos = purchaseAmount / PRICE_OF_LOTTO;
        Lottos lottos = new Lottos(totalNumberOfLottos);

        outputView.showTotalNumberOfLottos(totalNumberOfLottos);
        outputView.showRandomGeneratedLottos(lottos);

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.extractWinningNumber();
        Lotto winningLotto = new Lotto(parseNumbers(winningNumber));

        outputView.showLottoResult(FIFTH_PRIZE_MATCHING_NUMBER, FIFTH_PRIZE_REWARD, lottos.fifthPrize(winningLotto));
        outputView.showLottoResult(FOURTH_PRIZE_MATCHING_NUMBER, FOURTH_PRIZE_REWARD, lottos.fourthPrize(winningLotto));
        outputView.showLottoResult(THIRD_PRIZE_MATCHING_NUMBER, THIRD_PRIZE_REWARD, lottos.thirdPrize(winningLotto));
        outputView.showLottoResult(FIRST_PRIZE_MATCHING_NUMBER, FIRST_PRIZE_REWARD, lottos.firstPrize(winningLotto));

        outputView.showProfitRate(lottos.profitRate(winningLotto));
    }

    public static Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBERS);

        return new Lotto(LOTTO_NUMBERS.subList(STARTING_INDEX_LOTTO, LAST_INDEX_LOTTO));
    }
}
