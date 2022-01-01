package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoOutputView {

    private static final LottoOutputView OUTPUT_VIEW = new LottoOutputView();
    private static final String MONEY_PRINT_FORMAT = "(%s원)";

    private LottoOutputView() {

    }

    public static LottoOutputView getInstance() {
        return OUTPUT_VIEW;
    }

    public void showLottoTickets(int count, LottoTickets tickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", count, tickets.count() - count);
        System.out.println(tickets(tickets.getValues()));
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
                .map(entry -> rank(entry.getKey()) + "- " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }

    private String ticket(LottoNumbers numbers) {
        return numbers.getValues().stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String tickets(List<LottoNumbers> tickets) {
        return tickets.stream()
                .map(numbers -> ticket(numbers))
                .collect(Collectors.joining("\n"));

    }

    private String rank(Rank rank) {
        return rank.getMatches() + "개 일치" + bonus(rank) + money(rank.getReward());
    }

    private String bonus(Rank rank) {
        if (Rank.SECOND != rank) {
            return "";
        }
        return ", 보너스 볼 일치";
    }

    private String money(Money money) {
        return String.format(MONEY_PRINT_FORMAT, money.getAmount().toPlainString());
    }
}
