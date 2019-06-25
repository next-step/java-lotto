package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoAplication {

    public static void main(String[] args) {

        Order orderAmount = InputView.inputOrderAmount();
        LottoResultMatcher lottoResultMatcher = LottoStore.buyAutoPick(orderAmount);
        ResultView.printPickedLottoNumbers(lottoResultMatcher);

//        int handPickCount = InputView.handPickCount();
//
//        List<Integer> handPickNumbers = InputView.inputHandPickNumber();

        List<Integer> numbers = InputView.inputWinningNumber();
        int bonusNumber = InputView.winningBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winningNumbers);
        ResultView.printResult(lottoAggregator);
    }
}
