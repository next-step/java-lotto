package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {

        int price = InputView.inputPrice();
        LottoTicket lottoTicket = new LottoTicket(price);

        ResultView.printCount(lottoTicket.getCount());

        ResultView.printLottoNumber(lottoTicket.getLottoRowList());

    }
}
