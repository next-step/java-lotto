package lotto_auto.view;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;
import lotto_auto.service.LottoResult;

import java.util.List;

public class ResultView {
    public void printLottoResult(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        printLottoTickets(tickets);
    }

    public void printLottoTickets(LottoTickets tickets) {
        for (Lotto ticket : tickets.getLottoTickets()) {
            System.out.println(convertLottoNumbersToString(ticket.getNumbers()));
        }
    }

    private String convertLottoNumbersToString(List<LottoNumber> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int lastIndex = numbers.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            sb.append(numbers.get(i).getNumber());
            sb.append(", ");
        }
        sb.append(numbers.get(lastIndex).getNumber());

        sb.append("]");
        return sb.toString();
    }


    public void printStatistics(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개%n", result.getCountOfMatch(3));
        System.out.printf("4개 일치 (50000원)- %d개%n", result.getCountOfMatch(4));
        System.out.printf("5개 일치 (1500000원)- %d개%n", result.getCountOfMatch(5));
        System.out.printf("6개 일치 (2000000000원)- %d개%n", result.getCountOfMatch(6));
        printReturnStatus(result);
    }

    public void printReturnStatus(LottoResult result) {
        if (result.getRevenueRate() < 1) {
            System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", result.getRevenueRate());
            return;
        }

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)%n", result.getRevenueRate());

    }

}
