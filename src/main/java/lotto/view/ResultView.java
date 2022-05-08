package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Prize;

import java.util.function.Function;

public class ResultView {

    private static final String RESULT_MESSAGE = String.format("%s당첨 통계%s---------", System.lineSeparator(), System.lineSeparator());
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final Function<Number, String> WINNING_RATE_MESSAGE = winningRate -> String.format("총 수익률은 %s입니다.", winningRate.getDoubleValue());

    private ResultView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printPrize(Prize prize) {
        print(RESULT_MESSAGE);
        prize.getCountByRank()
                .entrySet()
                .stream()
                .filter(result -> result.getKey().getLongValue() > 2)
                .forEach(result -> printResult(result.getKey(), Prize.prizeByRank(result.getKey()).getPrize(), result.getValue()));

        Number winningRate = prize.getWinningRate();
        String winningRateMessage = WINNING_RATE_MESSAGE.apply(winningRate);

        if (winningRate.getLongValue() < 1) {
            winningRateMessage += LOSS_MESSAGE;
        }

        print(winningRateMessage);
    }

    public static void printResult(Number rank, Number prize, Number resultCount) {
        print(String.format("%s개 일치 (%s원)- %s개", rank, prize, resultCount));
    }
}
