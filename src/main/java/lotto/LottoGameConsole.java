package lotto;

import lotto.model.Lotto;
import lotto.service.PrizeStatisticsService;
import lotto.view.InputView;
import lotto.view.QuestionType;
import lotto.view.ResultView;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameConsole {

    public static void main(String args[]) {
        int money = InputView.inputInteger(QuestionType.MONEY_FOR_BUY.getQuestion());
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.buy(money);

        ResultView.printBoughtHistory(lottos);

        List<Integer> winningNumber = toIntegers(InputView.inputStrings(QuestionType.LAST_WEEKEND_PRIZE.getQuestion()));
        PrizeStatisticsService statisticsService = new PrizeStatisticsService();
        statisticsService.calculate(lottos, new HashSet<>(winningNumber));

        ResultView.printStatisticsOfPrize(statisticsService);
        ResultView.printReturnsOfInvestment(statisticsService, money);
    }

    private static List<Integer> toIntegers(List<String> strings) {
        return strings.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

}
