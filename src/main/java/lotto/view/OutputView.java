package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Prize;

public class OutputView {

    public static void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printReport(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        for (Prize prize : Prize.values()) {
            System.out.println(String.format("%d개 일치 (%d원)- %d개",
                    prize.getMatchCount(),
                    prize.getMoney(),
                    result.getCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %f입니다.", result.getRateOfReturn()));
    }
}
