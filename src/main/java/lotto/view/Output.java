package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Output {

    private final static String ENTER = System.lineSeparator();
    private final static String LOTTO_PURCHASE_MANUAL = "수동 로또 %d장 구매했습니다.";
    private final static String LOTTO_PURCHASE_AUTOMATIC = "자동 로또 %d장을 구매했습니다.";
    private final static String LOTTO_PURCHASE_COMPLEX = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private final static String LOTTO_RESULT = "== 로또 당첨 결과 ==";
    private final static String LOTTO_STATS_RANK = "%d개 일치 (%d원) - %d개";
    private final static String LOTTO_STATS_SECOND_RANK = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private final static String LOTTO_RETURN_INVESTMENT = "총 수익률은 %.2f 입니다.";

    private Output() {
        throw new AssertionError();
    }

    public static void printPurchaseTickets(final List<Lotto> lottoTickets, final int countOfAutomaticTickets, final int countOfManualTickets) {
        StringBuilder print = new StringBuilder(pickPrintLottoPurchaseDetail(countOfAutomaticTickets, countOfManualTickets))
                .append(ENTER);
        for (Lotto lotto : lottoTickets) {
            print.append(new TreeSet<>(lotto.lottoNumbers().stream()
                    .mapToInt(number -> number.lottoNumber())
                    .boxed()
                    .collect(Collectors.toList()))).append(ENTER);
        }
        System.out.println(print);
    }

    public static void printLottoResult(final List<Integer> lottoResult) {
        StringBuilder print = new StringBuilder(LOTTO_RESULT).append(ENTER);
        for (int i = 0; i < lottoResult.size(); i++) {
            print.append(String.format(pickPrintLottoStats(i)
                            , LottoPrize.values()[i].matchCount()
                            , LottoPrize.values()[i].amount()
                            , lottoResult.get(i)))
                    .append(ENTER);
        }
        System.out.println(print);
    }

    public static void printReturnOnInvestment(final double returnOnInvestment) {
        System.out.println(String.format(LOTTO_RETURN_INVESTMENT
                , returnOnInvestment));
    }

    private static String pickPrintLottoStats(int i) {
        return i == 1 ? LOTTO_STATS_SECOND_RANK : LOTTO_STATS_RANK;
    }

    private static String pickPrintLottoPurchaseDetail(final int countOfAutomaticTickets, final int countOfManualTickets) {
        if (countOfManualTickets >= 1 && countOfAutomaticTickets < 1) {
            return String.format(LOTTO_PURCHASE_MANUAL, countOfManualTickets);
        }
        if (countOfAutomaticTickets >= 1 && countOfManualTickets < 1) {
            return String.format(LOTTO_PURCHASE_AUTOMATIC, countOfAutomaticTickets);
        }
        if (countOfAutomaticTickets >= 1 && countOfManualTickets >= 1) {
            return String.format(LOTTO_PURCHASE_COMPLEX
                    , countOfManualTickets
                    , countOfAutomaticTickets);
        }
        throw new IllegalArgumentException("발급된 로또가 없습니다.");
    }
}
