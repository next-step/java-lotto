package lotto.step2.view.output;

import lotto.step2.domain.*;

public class ResultView {
    public static void purchasedLottoNumbersPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        System.out.printf("%d개를 구매했습니다.\n", paymentPrice.numberOfTickets());
        System.out.println(lottoTickets);
        System.out.println();
    }
    
    public static void winsNumbersPrint(WinsNumbers winsNumbers) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(winsNumbers);
    }
    
    public static void yieldPrint(PaymentPrice paymentPrice, ToTalReward totalReward) {
        double yield = Referee.yield(paymentPrice.paymentPriceInformation(), totalReward.totalRewardInformation());
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
