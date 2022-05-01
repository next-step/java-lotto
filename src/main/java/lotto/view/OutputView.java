package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Ranks;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        StringBuilder builder = new StringBuilder();
        lottoTickets.forEach(lottoTicket -> builder.append(lottoTicket.getLottoNumbers()).append("\n"));
        System.out.println(builder);
    }

    public void printResult(List<Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        List<Rank> collect = ranks.stream()
                .filter(r -> r >= 3)
                .map(Rank::getRank)
                .collect(Collectors.toList());
        Ranks ranks1 = new Ranks(collect);
        Map<Rank, Integer> rankIntegerMap = ranks1.groupBy();
        System.out.println("rankIntegerMap = " + rankIntegerMap);
        rankIntegerMap.forEach((rank, count) -> System.out.println(rank.getMatchNumberCount() + "개 일치" + rank.getPrize() * count + "원" + " - " + count + "개") );
    }
}
