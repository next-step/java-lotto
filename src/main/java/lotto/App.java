package lotto;

import java.util.List;

import static lotto.LottoStatistics.getLottoBuyingCount;

public class App {

    public static void main(String[] args) {
        int buyingMoney = InputView.getBuyingMoney();
        int lottoNum = getLottoBuyingCount(buyingMoney);
        OutputView.printBuyingCount(lottoNum);
        LottoTicket lottoTicket = new LottoTicket(lottoNum);
        OutputView.outputLottoList(lottoTicket);
        String lastWeekWinNumber = InputView.getLastWeekWinNumber();
        String bonusNumber = InputView.getBonusWinNumber();
        List<Integer> winNumber = InputView.convertWinNumberStringToIntegerList(lastWeekWinNumber);
        lottoTicket.compareWinList(winNumber);
        OutputView.printWinResult(lottoTicket);
    }
}
