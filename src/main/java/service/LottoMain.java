package service;

import domain.LottoUtil;
import view.InputView;
import view.ResultView;


public class LottoMain {
    public static void main(String[] args) {
        InputView.printInputView();
        String money = InputView.scanMoney();

        ResultView.printBuyManualLotto();
        int manualLottoCount = InputView.scanManualLottoCount();

        /* 자동로또 */
        // LottoService lottoService = new LottoService(LottoUtil.stringToInt(money));

        /* 수동로또 */
        LottoService lottoService = new LottoService(LottoUtil.stringToInt(money), manualLottoCount);

        String firstLottoInput = InputView.scanFirstLotto();
        String bonusNumberInput = InputView.scanBonusLottoNumer();

        lottoService.setFirstPlaceLotto(firstLottoInput, bonusNumberInput);

        lottoService.printLottoResult();
    }

}
