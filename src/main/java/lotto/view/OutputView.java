package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerLottoTicket;

public class OutputView {

    public static final Integer ONE_PRIZE = 2000000000;
    public static final Integer TWO_PRIZE = 1500000;
    public static final Integer THREE_PRIZE = 50000;
    public static final Integer FOUR_PRIZE = 5000;

    public void printLottoTicket(List<LottoTicket> lotto) {
        System.out.printf("%d개를 구매했습니다.\n", lotto.size());
        lotto.forEach(lottoTicket -> System.out.printf("[ %s ]\n", lottoTicket.joiningResult()));
    }

    public void printLottoResult(WinnerLottoTicket winner, List<LottoTicket> lottoTickets) {
        Map<Integer, List<Integer>> map = lottoTickets.stream()
            .map(winner::checkResult)
            .collect(Collectors.groupingBy(integer -> integer));
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        int fourNumber = map.get(3) == null ? 0 : map.get(3).size();
        System.out.printf("3개 일치 (" + FOUR_PRIZE + "원)- %d\n", fourNumber);
        int threeNumber = map.get(4) == null ? 0 : map.get(4).size();
        System.out.printf("4개 일치 (" + THREE_PRIZE + "원)- %d\n", threeNumber);
        int twoNumber = map.get(5) == null ? 0 : map.get(5).size();
        System.out.printf("5개 일치 (" + TWO_PRIZE + "원)- %d\n", twoNumber);
        int oneNumber = map.get(6) == null ? 0 : map.get(6).size();
        System.out.printf("6개 일치 (" + ONE_PRIZE + "원)- %d\n", oneNumber);

        Integer reward = fourNumber * FOUR_PRIZE + threeNumber * THREE_PRIZE + twoNumber
            * TWO_PRIZE + ONE_PRIZE * oneNumber;

        int inputMoney = LottoTicket.LOTTO_TICKET_PRICE * lottoTickets.size();

        float yield = (float) reward / inputMoney;
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n", yield,yield>1 ? "이득": "손해");

    }
}
