package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.Lottos;
import step2.domain.lotto.LottoNumber;
import step2.domain.money.Money;
import step2.domain.winning.WinningResult;
import step2.domain.winning.WinningScore;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ResultView {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n";
    private static final String PERFORATION = "---------\n";
    private static final String CORRECT_WINNING_LOTTO_MESSAGE = "%d개 일치 (%d)원 - %d개\n";
    private static final String TOTAL_YIELD_ANALYSIS_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]\n";
    private static final String DELIMITER = ", ";

    private static final double DIGIT_FORMAT = 100.0;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static ResultView instance;

    private ResultView() { }

    public final static ResultView getInstance() {
        if (isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    public final void printLottoList(Lottos lottos) {
        STRING_BUILDER.append(String.format(LOTTO_COUNT_MESSAGE, lottos.getLottosSize()));
        STRING_BUILDER.append(joinLottoNumbers(lottos));
        System.out.println(STRING_BUILDER.toString());
    }

    private StringBuilder joinLottoNumbers(Lottos lottos) {
        Set<Lotto> lottoList = lottos.getLottos();
        StringBuilder joinBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            String joinLottoNumber = lottoNumbers
                    .stream()
                    .map(ResultView::lottoNumberToString)
                    .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
            joinBuilder.append(joinLottoNumber);
        }
        return joinBuilder;
    }

    private static String lottoNumberToString(LottoNumber lottoNumber) {
        return String.valueOf(lottoNumber.getLottoNumber());
    }

    private void stringBuilderReset() {
        STRING_BUILDER.setLength(ZERO);
    }

    public final void printLottoResult(WinningResult winningResult, Money money) {
        stringBuilderReset();
        STRING_BUILDER.append(LOTTO_WINNING_STATISTICS_MESSAGE);
        STRING_BUILDER.append(PERFORATION);
        List<WinningScore> data = Arrays.stream(WinningScore.values()).collect(Collectors.toList());
        data.remove(WinningScore.MISS);
        for (WinningScore winningScore : data) {
            int correctCount = winningScore.getCorrectCount();
            int winningAmount = winningScore.getWinningAmount();
            int winningCount = winningResult.getMatchCount(winningScore);
            STRING_BUILDER.append(String.format(CORRECT_WINNING_LOTTO_MESSAGE, correctCount, winningAmount, winningCount));
        }

        double yield = doubleFormatting(getYield(winningResult, money.getMoney()));
        STRING_BUILDER.append(String.format(TOTAL_YIELD_ANALYSIS_MESSAGE, yield, chekProfitOrLoss(yield)));
        System.out.println(STRING_BUILDER.toString());
    }

    public final double getYield(WinningResult winningResult, int inputMoney) {
        if (inputMoney == ZERO) {
            return ZERO;
        }
        return ((double) getRevenue(winningResult) / (double) inputMoney);
    }

    private final int getRevenue(WinningResult winningResult) {
        return Arrays.stream(WinningScore.values())
                .mapToInt(winningScore ->
                        Math.multiplyExact(winningScore.getWinningAmount(), winningResult.getMatchCount(winningScore)))
                .sum();
    }

    private String chekProfitOrLoss(double yield) {
        return yield >= ONE ? "이익이" : "손해";
    }

    private double doubleFormatting(double yield) {
        return (Math.floor(yield * DIGIT_FORMAT)) / DIGIT_FORMAT;
    }

}
