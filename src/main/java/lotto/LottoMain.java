package lotto;


import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

import static lotto.utils.StringParser.stringToIntegerList;

public class LottoMain {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();

        Lotto lotto = new Lotto();
        lotto.sellLotto(lottoInputView.inputNumber("구매금액을 입력해주세요."));
        LottoResultView.printLotto(lotto);

        List<Integer> numbers = stringToIntegerList(lottoInputView.inputStringLine("당첨번호를 입력해주세요."));
        WinningNumbers winningNumbers = new WinningNumbers(numbers, lottoInputView.inputNumber("보너스번호를 입력해주세요."));

        LottoResult lottoResult = new LottoResult(lotto.makeStatistics(winningNumbers), lotto.calcRateOfReturn(winningNumbers));

        LottoResultView.printResult(lottoResult);
    }
}
