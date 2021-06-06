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

        int manualLottoNum = InputView.getManualLottoCount();
        buyingMoney.buyLotto(manualLottoNum);
        LottoTicket lottoTicket = new LottoTicket(InputView.getManualLottoNumber(manualLottoNum));

        int AutoLottoNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(manualLottoNum, AutoLottoNum);
        lottoTicket.addLotto(AutoLottoNum);
        return lottoTicket;
    }

    private static void checkWinLottoTicket(LottoTicket lottoTicket) {
        WinningLotto winningLotto = InputView.getLastWeekWinNumber();
        LottoNumber bonusNumber = InputView.getBonusWinNumber();
        lottoTicket.compareWinList(winningLotto, bonusNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
