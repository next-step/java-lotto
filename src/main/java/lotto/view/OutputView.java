package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.rank.Rank;
import lotto.domain.statistics.Count;
import lotto.domain.statistics.RateOfReturn;
import lotto.domain.statistics.WinningStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.view.MyPrinter.lineChange;
import static lotto.view.MyPrinter.printLine;

public class OutputView {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private OutputView() {}

    public static void printPurchasedLottos(Lottos manuals, Lottos autos) {
        if (manuals.isEmpty() && autos.isEmpty()) {
            return;
        }

        printPurchasedAmount(manuals.size(), autos.size());

        manuals.forEach(OutputView::printPurchasedLottoNumbers);
        autos.forEach(OutputView::printPurchasedLottoNumbers);

        lineChange();
    }

    private static void printPurchasedAmount(int manualAmount, int autoAmount) {
        printLine(String.format(Announcements.PURCHASE_AMOUNT_FORMAT, manualAmount, autoAmount));
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

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        printLine(String.format(Announcements.RATE_OF_RETURN_FORMAT, rateOfReturn.value(), RateOfReturnSubText.findByRateOfReturn(rateOfReturn).subText()));
    }

    private abstract static class Announcements {
        static final String PURCHASE_AMOUNT_FORMAT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
        static final String PURCHASED_LOTTO_NUMBER_TEMPLATE = "[%s]";

        static final String STATISTICS_TITLE = "당첨 통계\n---------";
        static final String RANK_COUNT_FORMAT = "%d개 일치 (%d원)- %d개";
        static final String SECOND_RANK_COUNT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
        static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f입니다.(%s)";
    }

    private enum RateOfReturnSubText {
        LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", val -> val.lessThan(1d)),
        TIE("기준이 1이기 때문에 또이또이라는 의미임", val -> val.equals(1d)),
        WIN("기준이 1이기 때문에 결과적으로 이득이라는 의미임", val -> val.greaterThan(1d))
        ;

        private final String subText;
        private final Predicate<RateOfReturn> predicate;

        RateOfReturnSubText(String subText, Predicate<RateOfReturn> predicate) {
            this.subText = subText;
            this.predicate = predicate;
        }

        public static RateOfReturnSubText findByRateOfReturn(RateOfReturn rateOfReturn) {
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
