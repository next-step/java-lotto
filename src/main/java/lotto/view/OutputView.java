package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(OutputView::printLottoTicket);
    }

    public static void printResults(LottoResult lottoResult, Money money) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n").append("---------\n");

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .forEach(rank -> {
                    stringBuilder.append(rank.getCountOfMatch()).append("개 일치 (");
                    stringBuilder.append(rank.getWinningMoney()).append(")- ");
                    stringBuilder.append(lottoResult.findByKey(rank)).append("개\n");
                });

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(money.calculateYield(lottoResult.addTotalMoney()));
        stringBuilder.append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

        System.out.println(stringBuilder.toString());
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String numbers = Arrays.toString(lottoTicket.getLottoNumbers().stream()
                .mapToInt(LottoNumber::getValue)
                .toArray());
        System.out.println(numbers);
    }
}
