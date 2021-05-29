package lotto;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        int buyingMoney = InputView.getBuyingMoney();
        int lottoNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(lottoNum);
        LottoTicket lottoList = new LottoTicket(lottoNum);
        OutputView.outputLottoList(lottoList.lottoList());
        String lastWeekWinNumber = InputView.getLastWeekWinNumber();
        int[] winNumber = InputView.convertWinNumberStringToIntArray(lastWeekWinNumber);
        lottoList.calculateWinList(winNumber);
        LottoStatistics lottoStatistics = lottoList.lottoStatistics();
        OutputView.printWinResult(lottoStatistics);
    }
}
