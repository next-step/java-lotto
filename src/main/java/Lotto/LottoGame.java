package Lotto;

import java.util.List;

public class LottoGame {

    private LottoList lottoList = new LottoList();

    public void start() {

        List<Lotto> list = lottoList.createLottoNumbers(changeMoneyToLottoNum());

        ResultView.viewLottoNumbers(list);
    }

    private int changeMoneyToLottoNum() {
        int lottoNums = InputView.inputBuyMoney();
        return lottoNums / 1000;
    }
}
