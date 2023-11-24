package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();

        Lotto lotto = new Lotto();
        lotto.sellLotto(lottoInputView.inputAmount("구매금액을 입력해주세요."));
        LottoResultView.printLotto(lotto);

        LottoNumbers winningNumber = new LottoNumbers(lottoInputView.inputStringLine("당첨번호를 입력해주세요."));

        LottoResult lottoResult = new LottoResult(lotto.makeStatistics(winningNumber), lotto.calcRateOfReturn(winningNumber));

        LottoResultView.printResult(lottoResult);
    }
}
