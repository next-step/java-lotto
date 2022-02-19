package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningPrice;

public class ResultView {

    private static final Character OPEN_CHAR = '[';
    private static final Character CLOSED_CHAR = ']';
    private static final String DELIMITER = ", ";
    private static final String DIVISION_LINE_FORMAT = "---------";
    private static final String NUMBER_OF_LOTTO_FORMAT = "수동으로 %d장, 자동으로%d개를 구매했습니다.%n";
    private static final String WIN_STATISTICS_FORMAT = "당첨통계";
    private static final String PROFITPERCENT_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

    public void printNumberOfLotto(final int lottoCounts, final int manualCounts) {
        System.out.printf(NUMBER_OF_LOTTO_FORMAT, manualCounts, lottoCounts);
    }

    public void printLottoTickets(final List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            System.out.print(OPEN_CHAR);
            String lottoNumbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber).map(Object::toString)
                .collect(Collectors.joining(DELIMITER));

            System.out.print(lottoNumbers);
            System.out.print(CLOSED_CHAR);
            System.out.println();
        }
    }

    public void printAnalyzeResults(final List<WinningPrice> winningPrices,
        final double profitPercent) {
        System.out.println(WIN_STATISTICS_FORMAT);
        System.out.println(DIVISION_LINE_FORMAT);

        printWinningMoney(winningPrices);
        printProfitPercent(profitPercent);
    }

    public void printWinningMoney(final List<WinningPrice> winningPrices) {
        for (WinningPrice price : winningPrices) {
            System.out.println(price);
        }
    }

    public void printProfitPercent(final double profitPercent) {
        System.out.printf(PROFITPERCENT_FORMAT, profitPercent);
    }
}
