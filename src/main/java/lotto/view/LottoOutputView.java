package lotto.view;

import lotto.domain.LotteryResult;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoOutputView {

    private static final LottoOutputView OUTPUT_VIEW = new LottoOutputView();

    private LottoOutputView() {

    }

    public static LottoOutputView getInstance() {
        return OUTPUT_VIEW;
    }

    public void showLottoTickets(LottoTickets tickets) {
        System.out.println(tickets.count() + "개를 구매했습니다.");
        System.out.println(tickets);
    }

    public void showLottoResult(LotteryResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(printStatistics(result.getStatistics()));
        System.out.println("총 수익률은 " + result.ratio() + "입니다.");
    }

    public String printStatistics(Map<Rank, Long> statistics) {
        return new TreeMap<>(statistics).entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .map(entry -> entry.getKey() + "- " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }
}
