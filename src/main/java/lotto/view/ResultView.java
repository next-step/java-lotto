package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Prize;
import lotto.model.Rank;

import java.util.Map;
import java.util.function.UnaryOperator;

import static lotto.model.Rank.MISS;
import static lotto.model.Rank.SECOND;

public class ResultView {

    private static final String FORMAT = "%s개 일치(%s원)- %s개";
    private static final String BONUS_FORMAT = "%s개, 보너스 볼 일치(%s원)- %s개";
    private static final String RESULT_SEPARATE_MESSAGE = String.format("당첨통계%s---------", System.lineSeparator());
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final UnaryOperator<String> RESULT_MESSAGE = winningRate -> String.format("총 수익률은 %s입니다.", winningRate);

    private static void print(Map.Entry<Rank, Number> rank) {
        String format = FORMAT;
        if (rank.getKey().equals(SECOND)) {
            format = BONUS_FORMAT;
        }
        String message = String.format(format, rank.getKey().getCorrectCount(), rank.getKey().getPrizeMoney(), rank.getValue());
        print(message);
    }

    private static void print(double winningRate) {
        String message = RESULT_MESSAGE.apply(String.valueOf(winningRate));
        if (winningRate < 1) {
            message += LOSS_MESSAGE;
        }

        print(message);
    }

    public static void print(Prize prize) {
        print();
        print(RESULT_SEPARATE_MESSAGE);
        prize.getRanks()
                .entrySet()
                .stream()
                .filter(rank -> !rank.getKey().equals(MISS))
                .forEach(ResultView::print);
        print(prize.getWinningRate());
    }

    public static void print() {
        print("");
    }

    public static void print(Lotto lotto) {
        print(lotto.toString());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
