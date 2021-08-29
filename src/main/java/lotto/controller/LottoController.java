package lotto.controller;

import lotto.domain.LottoEvent;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    LottoInputView lottoInputView;
    LottoOutputView lottoOutputView;
    LottoEvent lottoEvent;

    public LottoController() {
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
        lottoEvent = new LottoEvent();
    }

    public void lottoStart() {
        purchaseLotto();
        setWinningNumber();
        printResults();
    }

    private void purchaseLotto() {
        lottoOutputView.alertPurchaseMessage();
        int purchaseAmount = lottoInputView.getInt();
        lottoEvent.setPurchaseAmount(purchaseAmount);
        lottoOutputView.alertPurchaseListMessage(lottoEvent.getPurchaseLottoList());
    }

    private void setWinningNumber() {
        lottoOutputView.alertWinningNumber();
        List<Integer> winningNumber = lottoInputView.getIntegerList();
        lottoEvent.setWinningNumber(winningNumber);
    }

    private void printResults(){
        lottoOutputView.printResults(lottoEvent.getLottoResults());
    }
}
