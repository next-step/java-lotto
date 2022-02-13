package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningPrice;

public class ResultView {

    public void printNumberOfLotto(final int lottoCounts) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCounts);
    }

    public void printLottoTickets(final List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.print('[');

            String lottoNumbers = String.join(", ", lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber).map(Object::toString)
                .collect(Collectors.toList()));

            System.out.print(lottoNumbers);
            System.out.print(']');
            System.out.println();
        }
    }

    public void printAnalyzeResults(final List<WinningPrice> winningPrices,
        final double profitPercent) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printWinningMoney(winningPrices);
        printProfitPercent(profitPercent);
    }

    public void printWinningMoney(final List<WinningPrice> winningPrices) {
        for (WinningPrice price : winningPrices) {
            System.out.println(price);
        }
    }

    public void printProfitPercent(final double profitPercent) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitPercent);
    }
}
