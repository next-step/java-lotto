package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        long amount = InputView.purchaseAmount();
        LottoMachine machine = new LottoMachine();
        List<LottoNumbers> purchased = machine.buy(amount);
        ResultView.showPurchasedLottos(purchased);

        String lastWinning = InputView.inputLastWinningLottoNumbers();
        LottoNumbers winningNumbers = LottoNumbers.fromText(lastWinning);

        LottoNumberMatcher matcher = new LottoNumberMatcher(purchased, winningNumbers);
        LottoWinningRecord record = matcher.result();

        ResultView.showLottoWinningResult(record, purchased.size());
    }
}