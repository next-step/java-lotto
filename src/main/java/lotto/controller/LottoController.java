package lotto.controller;

import lotto.common.ErrorMessage;
import lotto.domain.BuyingCount;
import lotto.domain.BuyingLottos;
import lotto.domain.WanLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.data.LottoBuyingInfo;
import lotto.view.data.WinNumbers;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private BuyingLottos buyingLottos;
    private BuyingCount buyingCount;
    
    
    public LottoController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
    
    public void runBuyingLottoProcess() {
        LottoBuyingInfo buyingInfo = inputView.getLottoBuyingInfo();
        boolean canBuyingSelfLotto = BuyingLottos.canBuyingSelfLotto(buyingInfo.getCashPayment(), buyingInfo.getSelfCount());
        if (!canBuyingSelfLotto) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }
//        buyingLottos = new BuyingLottos();
        resultView.printLottos(buyingLottos);
    }
    
    public void runResultProcess() {
        WinNumbers winNumbers = inputView.getUserInputWinNumber();
        WanLottoNumbers wanLottoNumbers = new WanLottoNumbers(winNumbers.getWinNumbers(), winNumbers.getBonusWinNumber());
        resultView.printResult(buyingLottos.getOwnPrize(wanLottoNumbers));
    }
}
