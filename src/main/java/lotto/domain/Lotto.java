package lotto.domain;

import lotto.common.LottoConstants;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lotto {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoResult lottoResult = new LottoResult();

    public void lotto(){

        int buyMoney = inputView.count();

        int buyCount = lottoMachine.buyCount(buyMoney);
        resultView.print(buyCount);

        List<LottoNumbers> lottoNumbers = lottoMachine.lottoNumbers(buyCount);

        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        int bonusNumber = inputView.bonusBall();

        while (!lottoMachine.useAbleBonusBall(numbers, bonusNumber)) {
            System.out.println("보너스 볼은 당첨 번호와 달라야 합니다.");
            bonusNumber = inputView.bonusBall();
        }

        LottoNumber bonusBall = LottoNumber.lottoNumber(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusBall);

        String resultInfo = lottoResult.result(lottoNumbers, winningNumbers);

        resultView.print();
        resultView.print(resultInfo);

    }

}
