package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
                .map(Rank::getRank)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        Map<Rank, Long> collect1 = ranks.stream()
                .map(Rank::getRank)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Rank[] values = Rank.values();
        Arrays.stream(values).filter(v -> !collect1.containsKey(v))
                .forEach(v -> collect1.put(v, 0L));
        collect1.forEach((a, b) -> System.out.println(a.getMatchNumberCount() + "개 일치 " + a.getPrize() * b + "원" + " - " + b +"개"));
    }
}
