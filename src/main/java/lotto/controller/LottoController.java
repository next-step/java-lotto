package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private LottoInputView lottoInputView;
    private LottoOutputView lottoOutputView;

    private PurchaseAmount purchaseAmount;
    private PurchaseLottos purchaseLottos;
    private Lotto winningNumber;
    private LottoResults lottoResults;

    public LottoController() {
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
    }

    public void lottoStart() {
        purchaseLotto();
        setWinningNumber();
        printResults();
    }

    private void purchaseLotto() {
        lottoOutputView.alertPurchaseMessage();
        int purchaseAmount = lottoInputView.getInt();
        setPurchaseAmount(purchaseAmount);
        lottoOutputView.alertPurchaseListMessage(getPurchaseLottoList());
    }

    private void setWinningNumber() {
        lottoOutputView.alertWinningNumber();
        List<Integer> winningNumber = lottoInputView.getIntegerList();
        setWinningNumber(winningNumber);
    }

    private void printResults() {
        setLottoResults();
        lottoOutputView.printResults(getLottoResults());
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        purchaseLottos = new PurchaseLottos(this.purchaseAmount.getLottoCount());
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }

    public void setLottoResults() {
        List<Integer> sameNumberCounts = purchaseLottos.getPurchaseLottoList()
                .stream()
                .mapToInt(lotto -> lotto.sameLottoNumberCount(winningNumber))
                .boxed()
                .collect(Collectors.toList());

        lottoResults = new LottoResults(sameNumberCounts);
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottos.getPurchaseLottoList();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
