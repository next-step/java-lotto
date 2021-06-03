package lotto;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        Money buyingMoney = InputView.getBuyingMoney();
        int lottoBuyingNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(lottoBuyingNum);
        LottoTicket lottoTicket = new LottoTicket(lottoBuyingNum);
        OutputView.outputLottoList(lottoTicket);
        WinningLotto winningLotto=InputView.getLastWeekWinNumber();
        LottoNumber bonusNumber = InputView.getBonusWinNumber();
        lottoTicket.compareWinList(winningLotto, bonusNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
