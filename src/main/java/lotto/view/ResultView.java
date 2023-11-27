package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Rank;
import lotto.domain.LottoTicket;

public class ResultView {
    public void showHowManyBuyTicket(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.append("개 를 구매했습니다.");
        System.out.println(sb);
    }

    public void showLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            showLottoTicket(ticket);
        }
    }

    private void showLottoTicket(LottoTicket ticket) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ticket.getNumbers().size(); i++) {
            sb.append(ticket.getNumbers().get(i).getNum());
            // StringBuilder를 넘겨받아 indent를 줄이는 것이 좋을까?
            addComma(ticket, sb, i);
        }
        sb.append("]");
        System.out.println(sb);
    }

    private void addComma(LottoTicket ticket, StringBuilder sb, int i) {
        if (i != ticket.getNumbers().size() - 1)
            sb.append(", ");
    }

    public void showResultStatics(EnumMap<Rank, Integer> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("----------\n");
        for (Map.Entry<Rank, Integer> result : results.entrySet()) {
            sb.append(result.getKey().getMatchCount() + "개 일치");
            sb.append("(" + result.getKey().getAmount() + ")- ");
            sb.append(" " + result.getValue() + "개");
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public void showReturnRate(Double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
