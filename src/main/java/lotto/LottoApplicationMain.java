package lotto;

import lotto.domian.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoApplicationMain {

    public static void main(String[] args) {
        int purchaseMoney = InputView.questionOrder();
        int manualOrderCount = InputView.questionManualOrder();

        Store store = new Store();
        Money change = store.orderManual(new Money(purchaseMoney), manualOrderCount);
        List<String> manualLottos = InputView.questionLottoNumbers(manualOrderCount);

        LottoCompany lottoCompany = LottoCompany.getInstance();
        ManualLottoBundle manualLottoBundle = lottoCompany.makeManualBundle(manualLottos);
        LottoBundle autoLottoBundle = store.order(change);
        LottoGroup lottoGroup = new LottoGroup(manualLottoBundle, autoLottoBundle);

        OutputView.showLottoGroup(lottoGroup);

        String answerNumbers = InputView.questionWinnerNumber();
        String bonusWinNumber = InputView.questionBonusNumber();

        WinNumber winNumber = lottoCompany.announce(answerNumbers, bonusWinNumber);
        Record record = Record.extractRecord(lottoGroup.getGroupBundle(), winNumber);
        OutputView.showRecord(record);

        ProfitCalculator profitCalculator = new ProfitCalculator(new MultiplyStrategy());
        OutputView.showProfitRate(profitCalculator.calculate(record.getRecord(), purchaseMoney));
    }
}