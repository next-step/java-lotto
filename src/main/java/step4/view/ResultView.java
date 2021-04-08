package step4.view;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import step4.domain.money.Money;
import step4.domain.rank.Rank;
import step4.domain.winning.WinningResult;

import java.util.*;
import java.util.stream.Collectors;

public final class ResultView {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n";
    private static final String PERFORATION = "---------\n";
    private static final String CORRECT_WINNING_LOTTO_MESSAGE = "%d개 일치 (%d)원 - %d개\n";
    private static final String CORRECT_WINNING_LOTTO_MESSAGE_IN_SECOND = "%d개 일치, 보너스 볼 일치(%d)원 - %d개\n";
    private static final String TOTAL_YIELD_ANALYSIS_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]\n";
    private static final String DELIMITER = ", ";

    private static final double DIGIT_FORMAT = 100.0;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static class ResultViewHolder {
        public static final ResultView instance = new ResultView();
    }

    private ResultView() {
    }

    public static final ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public final void printLottoList(List<Lotto> lottos) {
        STRING_BUILDER.append(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));
        STRING_BUILDER.append(joinLottoNumbers(lottos));
        System.out.println(STRING_BUILDER.toString());
    }

    private final StringBuilder joinLottoNumbers(List<Lotto> lottos) {
        StringBuilder joinBuilder = new StringBuilder();
        lottos.stream()
                .map(Lotto::getLotto)
                .map(this::getEachLottoString)
                .forEach(joinBuilder::append);
        return joinBuilder;
    }

    private final String getEachLottoString(Set<LottoNumber> lottoNumbers) {
        return getJoinedLotto(setToSortedList(lottoNumbers));
    }

    private final List<LottoNumber> setToSortedList(Set<LottoNumber> lottoNumbers) {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private final String getJoinedLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public final void printLottoResult(WinningResult winningResult, Money money) {
        STRING_BUILDER.setLength(ZERO);
        STRING_BUILDER.append(LOTTO_WINNING_STATISTICS_MESSAGE);
        STRING_BUILDER.append(PERFORATION);
        List<Rank> ranks = Arrays.stream(Rank.values()).collect(Collectors.toList());
        ranks.remove(Rank.MISS);
        for (Rank rank : ranks) {
            int countOfMatch = rank.getCountOfMatch();
            int winningMoney = rank.getWinningMoney();
            long winningCount = winningResult.getWinningCount(rank);
            STRING_BUILDER.append(getLottoResultFormat(rank, countOfMatch, winningMoney, winningCount));
        }
        double yield = doubleFormatting(getYield(winningResult, money.getMoney()));
        STRING_BUILDER.append(String.format(TOTAL_YIELD_ANALYSIS_MESSAGE, yield, chekProfitOrLoss(yield)));
        System.out.println(STRING_BUILDER.toString());
    }

    private final String getLottoResultFormat(Rank rank, int countOfMatch, int winningMoney, long winningCount) {
        if (rank == Rank.SECOND) {
            return String.format(CORRECT_WINNING_LOTTO_MESSAGE_IN_SECOND, countOfMatch, winningMoney, winningCount);
        }
        return String.format(CORRECT_WINNING_LOTTO_MESSAGE, countOfMatch, winningMoney, winningCount);
    }

    private final double doubleFormatting(double yield) {
        return (Math.floor(yield * DIGIT_FORMAT)) / DIGIT_FORMAT;
    }

    public final double getYield(WinningResult winningResult, int inputMoney) {
        if (inputMoney == ZERO) {
            return ZERO;
        }
        return ((double) getRevenue(winningResult) / (double) inputMoney);
    }

    private final long getRevenue(WinningResult winningResult) {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> getProfit(rank, winningResult))
                .sum();
    }

    private final long getProfit(Rank rank, WinningResult winningResult) {
        return Math.multiplyExact(rank.getWinningMoney(), winningResult.getWinningCount(rank));
    }

    private final String chekProfitOrLoss(double yield) {
        return yield >= ONE ? "이익이" : "손해";
    }


}
