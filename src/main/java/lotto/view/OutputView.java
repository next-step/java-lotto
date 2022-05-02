package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Ranks;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        StringBuilder builder = new StringBuilder();
        lottoTickets.forEach(lottoTicket ->
                builder.append(lottoTicket.getLottoNumbers()).append("\n"));
        System.out.println(builder);
    }

    public void printResult(List<Integer> matchNumbers) {
        System.out.println("\n당첨 통계\n--------");
        Map<Rank, Integer> resultMap = Ranks.getGroupByMap(matchNumbers);
        resultMap.forEach((rank, count) -> System.out.println(rank.getMatchNumberCount()
                + "개 일치 " + rank.getPrize() * count + "원 - " + count + "개"));
    }
}
