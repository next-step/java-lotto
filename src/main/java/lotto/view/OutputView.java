package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.view.MyPrinter.lineChange;
import static lotto.view.MyPrinter.printLine;

public class OutputView {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private OutputView() {}

    public static void printPurchasedLottos(Lottos lottos) {
        printPurchasedAmount(lottos.size());
        if (!lottos.isEmpty()) {
            lottos.forEach(OutputView::printPurchasedLottoNumbers);
        }
        lineChange();
    }

    private static void printPurchasedAmount(int amount) {
        printLine(String.format(Announcements.PURCHASE_AMOUNT_FORMAT, amount));
    }

    private static void printPurchasedLottoNumbers(Lotto lotto) {
        printLine(
                String.format(
                        Announcements.PURCHASED_LOTTO_NUMBER_TEMPLATE,
                        joinLottoNumbers(lotto.numbers())));
    }

    private static String joinLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
    }

    public static void printWinningCounts(WinningStatistics statistics) {
        printLine(Announcements.STATISTICS_TITLE);

        Rank.winRanks().forEach(rank -> printRankCount(rank, statistics.rankCount(rank)));
    }

    private static void printRankCount(Rank rank, Count count) {
        printLine(String.format(rankCountFormat(rank), rank.matchCount(), rank.winnings(), count.value()));
    }

    private static String rankCountFormat(Rank rank) {
        if (rank.needBonusMatch()) {
            return Announcements.SECOND_RANK_COUNT_FORMAT;
        }
        return Announcements.RANK_COUNT_FORMAT;
    }

    public static void printRateOfReturn(double rateOfReturn) {
        printLine(String.format(Announcements.RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturnSubText.findByRateOfReturn(rateOfReturn).subText()));
    }

    private abstract static class Announcements {
        static final String PURCHASE_AMOUNT_FORMAT = "%d개를 구매했습니다.";
        static final String PURCHASED_LOTTO_NUMBER_TEMPLATE = "[%s]";

        static final String STATISTICS_TITLE = "당첨 통계\n---------";
        static final String RANK_COUNT_FORMAT = "%d개 일치 (%d원)- %d개";
        static final String SECOND_RANK_COUNT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
        static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f입니다.(%s)";
    }

    private enum RateOfReturnSubText {
        LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", val -> val < 1d),
        TIE("기준이 1이기 때문에 또이또이라는 의미임", val -> val == 1d),
        WIN("기준이 1이기 때문에 결과적으로 이득이라는 의미임", val -> val > 1d)
        ;

        private final String subText;
        private final Predicate<Double> predicate;

        RateOfReturnSubText(String subText, Predicate<Double> predicate) {
            this.subText = subText;
            this.predicate = predicate;
        }

        public static RateOfReturnSubText findByRateOfReturn(double rateOfReturn) {
            return Arrays.stream(values())
                    .filter(type -> type.predicate.test(rateOfReturn))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("정상적이지 않은 수익률입니다."));
        }

        public String subText() {
            return subText;
        }
    }
}
