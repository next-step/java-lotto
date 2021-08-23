package Main;

import UI.InputView;
import UI.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputView.askUserToPayForLottoTickets();
        ResultView.showTotalNumberOfPurchasedLottoTickets(price); // TODO: 총 지불액은 1000의 배수여야한다.
    }
}
