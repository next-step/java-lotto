package step2;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public void printLottoCount(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.print("[");
            List<Integer> numbers = ticket.lottos().stream().collect(ArrayList::new, (list, lotto) -> list.add(lotto.number()), ArrayList::addAll);
            numbers.sort(Integer::compareTo);
            printLottoNumber(numbers);
            System.out.println("]");
            System.out.println();
        }
    }

    private void printLottoNumber(List<Integer> numbers) {
        numbers.forEach((number) -> {
            System.out.print(number);
            addDelimiter(numbers.indexOf(number), numbers.size());
            });
    }

    private void addDelimiter(int i, int size) {
        if (i != size - 1) {
            System.out.print(", ");
        }
    }

    public void printLottoResult(int ticketMoney, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoResult.countOfMatch(LottoRank.FIFTH.countOfMatch()));
        System.out.println("4개 일치 (50000원)- " + lottoResult.countOfMatch(LottoRank.FOURTH.countOfMatch()));
        System.out.println("5개 일치 (1500000원)- " + lottoResult.countOfMatch(LottoRank.THIRD.countOfMatch()));
        System.out.println("6개 일치 (2000000000원)- " + lottoResult.countOfMatch(LottoRank.FIRST.countOfMatch()));
        System.out.println("총 수익률은 " + new LottoProfit().profit(ticketMoney, lottoResult) + "입니다.");
    }
}
