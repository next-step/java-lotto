package service;

import domain.LottoUtil;
import view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView.printInputView();
        String money = InputView.scanMoney();

        LottoService lottoService = new LottoService(LottoUtil.stringToInt(money));

        String firstLottoInput = InputView.scanFirstLotto();
        String bonusNumberInput = InputView.scanBonusLottoNumer();

        lottoService.setFirstPlaceLotto(firstLottoInput, bonusNumberInput);

        lottoService.calculateLottoRank();

        lottoService.printLottoResult();
    }

}
