package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Prize;

public class OutputView {

    public static final String RESULT_PRIZE_MESSAGE = "%d개 일치 (%d원)- %d개";
    public static final String RESULT_PRIZE_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";

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
            String printMessage = (prize.equals(Prize.SECOND)) ? RESULT_PRIZE_SECOND_MESSAGE : RESULT_PRIZE_MESSAGE;
            System.out.println(String.format(printMessage,
                    prize.getMatchCount(),
                    prize.getMoney(),
                    result.getCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %f 입니다.", result.getRateOfReturn()));
    }
}
