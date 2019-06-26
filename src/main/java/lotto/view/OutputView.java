package lotto.view;

import lotto.model.*;

public class OutputView {

    public static final String RESULT_PRIZE_MESSAGE = "%d개 일치 (%s원)- %d개";
    public static final String RESULT_PRIZE_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원)- %d개";

    public static void printNumberOfBuyLotto(PurchaseRequest purchaseRequest) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
                purchaseRequest.countOfManualLotto(),
                purchaseRequest.countOfRandomLotto()));
        System.out.println();
    }

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
                    result.countOfPrize(prize)));
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 %f 입니다.", rateOfReturn));
    }
}
