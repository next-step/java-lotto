package autolotto;

public class App {

    public static void main(String[] args) {
        int buyingMoney = InputView.getBuyingMoney();
        int lottoNum = LottoUtil.getLottoBuyingCount(buyingMoney);
        InputView.outBuyingCount(lottoNum);
        LottoList lottoList = new LottoList(lottoNum);
        InputView.outputLottoList(lottoList.lottoList());
        String lastWeekWinNumber = InputView.getLastWeekWinNumber();
        lottoList.calculateWinList(LottoUtil.convertWinNumberStringToIntArray(lastWeekWinNumber));
        InputView.outputWinResult(lottoList.outPutWinList());
    }

}
