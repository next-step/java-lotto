package step3.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3.io.ConsoleInputView;
import step3.io.ConsoleResultView;
import step3.model.LottoNumbers;
import step3.model.PurchaseInfo;
import step3.model.RandomNumbersGenerator;
import step3.model.TotalLotto;

public class Lotto {

    private ConsoleInputView inputView;
    private ConsoleResultView resultView;
    private TotalLotto totalLotto;
    private PurchaseInfo purchaseInfo;

    public Lotto() {
        this.inputView = new ConsoleInputView();
        this.resultView = new ConsoleResultView();
    }

    public void start() {
        buy();
        statistics();
    }

    private void buy() {
        try {
            setPrice();
            totalLotto = new TotalLotto(getLottoNeberWithPrice());
            resultView.buyCount(purchaseInfo);
            resultView.showTextStatus(totalLotto);
            resultView.showEmptyLine();
        } catch (IllegalArgumentException e) {
            resultView.showText(e.getMessage());
            buy();
        }

    }

    private List<LottoNumbers> getLottoNeberWithPrice() {
        List<LottoNumbers> totalNumbers = new ArrayList<>();
        totalNumbers.addAll(pickAutoLottoWithPrice(purchaseInfo));
        totalNumbers.addAll(pickManulLottoWithPrice(purchaseInfo));

        return totalNumbers;
    }

    private void setPrice() {
        int totalPrice = inputView.getPrice();
        int manualCount = inputView.getManulCount();
        purchaseInfo = new PurchaseInfo(totalPrice, manualCount);
    }

    public void statistics() {
        try {
            LottoNumbers victoryNumber = getVictoryNumbers();
            resultView
                .showWinning((totalLotto.groupByWinnerPrice(victoryNumber)));
            resultView
                .showBenefit(
                    totalLotto.getBenefit(victoryNumber, purchaseInfo));

        } catch (IllegalArgumentException e) {
            resultView.showText(e.getMessage());
            statistics();
        }

    }

    private LottoNumbers getVictoryNumbers() {
        return LottoNumbers.of(inputView.getVictoryNumbers(),
            inputView.getBonusNumber());
    }

    protected List<LottoNumbers> pickAutoLottoWithPrice(
            PurchaseInfo purchaseInfo) {
        return purchaseInfo.getBuyAutoCountStream()
            .boxed()
            .map(number -> LottoNumbers
                .of(RandomNumbersGenerator.createNumbers()))
            .collect(Collectors.toList());
    }

    private List<LottoNumbers> pickManulLottoWithPrice(PurchaseInfo price) {
        inputView.getManulNumber();
        return price.getBuyManualCountStream()
            .boxed()
            .map(number -> LottoNumbers.of(inputView.getText()))
            .collect(Collectors.toList());
    }

}
