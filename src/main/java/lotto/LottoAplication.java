package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoAplication {

    public static void main(String[] args) {

        Order orderAmount = InputView.inputOrderAmount();
        Lottos lottos = LottoRetailer.buyAutoPick(orderAmount);
        ResultView.printPickedLottoNumbers(lottos);

        int handPickCount = InputView.handPickCount();

        List<Integer> handPickNumbers = InputView.inputHandPickNumber();

        List<Integer> numbers = InputView.inputWinningNumber();
        int bonusNumber = InputView.winningBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        LottoAggregator lottoAggregator = lottos.matching(winningNumbers);
        ResultView.printResult(lottoAggregator);
    }
}
