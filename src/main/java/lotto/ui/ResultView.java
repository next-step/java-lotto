package lotto.ui;

import lotto.service.domain.types.Rank;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;

import java.util.Arrays;
import java.util.Comparator;

public class ResultView {
    private static final String ENTER = "\r\n";

    public void printPurchaseLottoTickets(LottoTickets lottoTickets) {
        System.out.println(toString(lottoTickets));
    }

    public void printLottoResult(LottoResult lottoResult, LottoPrice purchasePrice) {
        System.out.println(toString(lottoResult, purchasePrice));
    }

    private String toString(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s개를 구매했습니다.", lottoTickets.getCountOfLottoTickets())).append(ENTER);
        lottoTickets.getLottoTickets().forEach(
                lottoTicket -> sb.append("[").append(lottoTicket.getLottoNumbersToString()).append("]").append(ENTER));
        return sb.toString();
    }

    private String toString(LottoResult lottoResult, LottoPrice purchasePrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append(ENTER);
        sb.append("---------").append(ENTER);

        Arrays.stream(Rank.values())
                .filter(rank -> Rank.MISS != rank)
                .sorted(Comparator.comparing(Rank::getSort))
                .forEach(rank -> getWinningStatistics(sb, lottoResult, rank));

        sb.append(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                                lottoResult.getLottoYield(purchasePrice), lottoResult.getProfitOrLoss(purchasePrice)))
                .append(ENTER);
        return sb.toString();
    }

    private void getWinningStatistics(StringBuilder sb, LottoResult lottoResult, Rank rank) {
        String bonusMessage = "";
        if (Rank.SECOND == rank) {
            bonusMessage = ", 보너스 볼 일치";
        }
        sb.append(String.format("%d개 일치%s(%d원)- %d개",
                                rank.getCountOfMatch(), bonusMessage, rank.getWinningMoney(),
                                lottoResult.getCountOfWinning(rank))).append(ENTER);
    }
}
