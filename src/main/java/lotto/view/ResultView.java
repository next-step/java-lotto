package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Prize;

import java.util.function.Function;

public class ResultView {

    private static final String RESULT_MESSAGE = String.format("%s당첨 통계%s---------", System.lineSeparator(), System.lineSeparator());
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final Function<Double, String> WINNING_RATE_MESSAGE = winningRate -> String.format("총 수익률은 %s입니다.", winningRate);

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
                .filter(result -> result.getKey().getValue() > 2)
                .forEach(result -> printResult(result.getKey(), Prize.prizeByRank(result.getKey()), result.getValue()));

        double winningRate = prize.getWinningRate();
        String winningRateMessage = WINNING_RATE_MESSAGE.apply(winningRate);

        if (winningRate < 1) {
            winningRateMessage += LOSS_MESSAGE;
        }

        print(winningRateMessage);
    }

    public static void printResult(Number rank, Number prize, Number resultCount) {
        print(String.format("%s개 일치 (%s원)- %s개", rank, prize, resultCount));
    }
}
