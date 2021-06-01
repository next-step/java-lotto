package lotto;

import java.util.List;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        Money buyingMoney = InputView.getBuyingMoney();
        int lottoNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(lottoNum);
        LottoTicket lottoTicket = new LottoTicket(lottoNum);
        OutputView.outputLottoList(lottoTicket);
        WinningLotto winningLotto=InputView.getLastWeekWinNumber();
        LottoNumber bonusNumber = InputView.getBonusWinNumber();
        lottoTicket.compareWinList(winningLotto, bonusNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
