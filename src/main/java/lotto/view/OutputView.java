package lotto.view;

import lotto.LottoTickets;

import java.util.Arrays;

public class OutputView {
    public static void requestAmountOfPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void displayNumberOfPurchasedTickets(int amountOfPurchase) {
        System.out.println(amountOfPurchase/1000+"개를 구매했습니다.");
    }

    public static void displayLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.tickets().forEach(lottoTicket -> {
            System.out.println(lottoTicket.toString());
        });
    }
}
