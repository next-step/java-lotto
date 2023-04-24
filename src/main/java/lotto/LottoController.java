package lotto;

import lotto.View.InputView;

public class LottoController {
    public void buy() {
        int countOfTicket = InputView.payment();
        System.out.println(countOfTicket+"개를 구매했습니다.");

    }
}
