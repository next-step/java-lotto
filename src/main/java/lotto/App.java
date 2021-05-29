package lotto;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        int buyingMoney = InputView.getBuyingMoney();
        int lottoNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(lottoNum);
        LottoTicket lottoTicket = new LottoTicket(lottoNum);
        OutputView.outputLottoList(lottoTicket.lottoList());
        String lastWeekWinNumber = InputView.getLastWeekWinNumber();
        int[] winNumber = InputView.convertWinNumberStringToIntArray(lastWeekWinNumber);
        lottoTicket.compareWinList(winNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
