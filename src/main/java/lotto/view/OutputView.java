package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Money;
import lotto.domain.numbers.LottoTickets;

import java.util.Arrays;

public class OutputView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getCount() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(OutputView::printLottoTicket);
    }

    public static void printResults(LottoResult lottoResult, Money money) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n").append("---------\n");

        Arrays.stream(Rank.values())
                .filter(Rank::isNotMiss)
                .forEach(rank -> stringBuilder.append(rankToString(rank, lottoResult.findByKey(rank))));

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

    private static String rankToString(Rank rank, int countOfMatchRank) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getCountOfMatch()).append("개 일치");

        if (rank.isSecond()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(rank.getWinningMoney()).append(")- ");
        sb.append(countOfMatchRank).append("개\n");

        return sb.toString();
    }
}
