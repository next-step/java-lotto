package lotto.step2.view.output;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;

public class ResultView {
    public static void purchasedLottoNumbersPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        System.out.printf("%d개를 구매했습니다.\n", paymentPrice.numberOfTickets());
        System.out.println(lottoTickets);
    }
}
