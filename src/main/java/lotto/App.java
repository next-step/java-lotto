package lotto;

import lotto.domain.LottoBonus;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class App {

    public static void main(String[] args) {
        Lottos buyTickets = Lottos.of(buyTicket());
        ResultView.printBuyTicket(buyTickets);

        LottoNumbers winTicket = getWinTicket();
        LottoNumber bonusNumber = getBonusNumber();

        ResultView.printStatistics(buyTickets, LottoBonus.of(winTicket, bonusNumber));
    }

    private static LottoNumbers getWinTicket() {
        return LottoNumbers.of(InputView.getInputWinNumbers());
    }

    private static LottoNumber getBonusNumber() {
        String inputBonusNumber = InputView.getInputBonusNumber();
        return LottoNumber.of(inputBonusNumber);
    }

    private static int buyTicket() {
        int money = InputView.getInputBuyMoney();
        InputView.printBuyCount(money);

        return money;
    }
}
