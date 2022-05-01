package lotto.model;

import lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private static final Function<Integer, String> BUY_LOTTO_MESSAGE = total -> total + "개를 구매했습니다.";
    private static final String BUY_EXCEPTION_MESSAGE = "로또 구매 가격은 장당 1000원입니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private int prise;
    private List<Lotto> lottoList;

    public List<Lotto> buyLotto(int prise) {
        this.prise = prise;
        int lottoCount = this.checkPrise(prise);
        ResultView.print(BUY_LOTTO_MESSAGE.apply(lottoCount));

        this.lottoList = IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto().draw())
                .peek(lotto -> ResultView.print(lotto.toString()))
                .collect(Collectors.toList());

        return this.lottoList;
    }

    public double result(Lotto beforeLotto) {
        ResultView.print(RESULT_MESSAGE);

        int totalPrize = IntStream
                .range(3, 7)
                .map(correctNumber -> {
                    int prize = prizeByCorrect(correctNumber);
                    int resultCount = this.countByResult(correctNumber, beforeLotto);
                    ResultView.printResult(correctNumber, prize, resultCount);

                    return Math.multiplyExact(prize, resultCount);
                })
                .sum();

        return this.getProfitRate(totalPrize);
    }

    private int countByResult(int correctNumber, Lotto beforeLotto) {
        return (int) this.lottoList
                .stream()
                .map(lotto -> lotto.contains(beforeLotto))
                .filter(count -> Objects.equals(correctNumber, count))
                .count();
    }

    private int prizeByCorrect(int correctNumber) {
        if (correctNumber == 4) {
            return 50000;
        }

        if (correctNumber == 5) {
            return 1500000;
        }

        if (correctNumber == 6) {
            return 2000000000;
        }

        return 5000;
    }

    private double getProfitRate(int totalPrize) {
        BigDecimal prise = new BigDecimal(this.prise);
        BigDecimal prize = new BigDecimal(totalPrize);

        double probability = prize.divide(prise, 2, RoundingMode.HALF_EVEN).doubleValue();

        String message = String.format("총 수익률은 %s입니다.", probability);
        if (probability < 1) {
            message += LOSS_MESSAGE;
        }
        ResultView.print(message);

        return probability;
    }

    private int checkPrise(int prise) {
        int lottoCount = prise / 1000;
        if (prise < 1000 || prise % 1000 != 0) {
            throw new IllegalArgumentException(BUY_EXCEPTION_MESSAGE);
        }
        return lottoCount;
    }
}
