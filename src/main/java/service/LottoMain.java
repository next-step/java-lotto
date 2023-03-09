package service;

import domain.FirstLotto;
import domain.LottoUtil;
import view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView.printInputView();
        String money = InputView.scanMoney();

        LottoService lottoService = new LottoService(LottoUtil.stringToInt(money));

        String firstLottoInput = InputView.scanFirstLotto();
        String bonusNumberInput = InputView.scanBonusLottoNumer();

        FirstLotto firstLotto = new FirstLotto(firstLottoInput, bonusNumberInput);

    }

}
