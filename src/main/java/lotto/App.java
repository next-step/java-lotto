package lotto;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        LottoTicket lottoTicket = buyLottoTicket();
        OutputView.outputLottoList(lottoTicket);
        checkWinLottoTicket(lottoTicket);
    }

    private static LottoTicket buyLottoTicket() {
        Money buyingMoney = InputView.getBuyingMoney();

        BuyingCount manualLottoBuyingNum = InputView.getManualLottoCount();
        buyingMoney.buyLotto(manualLottoBuyingNum);
        LottoTicket lottoTicket = new LottoTicket(InputView.getManualLottoNumber(manualLottoBuyingNum));

        BuyingCount autoLottoBuyingNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(manualLottoBuyingNum, autoLottoBuyingNum);
        lottoTicket.addLotto(autoLottoBuyingNum);
        return lottoTicket;
    }

    private static void checkWinLottoTicket(LottoTicket lottoTicket) {
        WinningLotto winningLotto = InputView.getLastWeekWinNumber();
        LottoNumber bonusNumber = InputView.getBonusWinNumber();
        lottoTicket.compareWinList(winningLotto, bonusNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
