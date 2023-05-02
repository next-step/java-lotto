package lotto_second.view;

import lotto_second.domain.Lotto;
import lotto_second.domain.LottoNumber;
import lotto_second.domain.LottoTickets;
import lotto_second.domain.Rank;
import lotto_second.service.LottoResult;

import java.util.List;

public class ResultView {
    public void printLottoResult(LottoTickets manualTickets, LottoTickets autoTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualTickets.size(), autoTickets.size());
        printLottoTickets(manualTickets);
        printLottoTickets(autoTickets);
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
        for (Rank rank : Rank.values()) {
            String bonusMessage = "";
            if (rank == Rank.MISS) {
                continue;
            }

            if (rank == Rank.SECOND) {
                bonusMessage = ", 보너스 볼 일치";
            }

            System.out.printf("%d개 일치%s (%d원)- %d개%n", rank.getCountOfMatch(), bonusMessage, rank.getWinningMoney(), result.getCountOfMatch(rank));
        }
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
