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

        int buyCount = inputView.count();

        resultView.print(buyCount);

        List<LottoNumbers> lottoNumbers = lottoMachine.lottoNumbers(buyCount);

        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        int bonusBall = inputView.bonusBall();

        while (!lottoMachine.useAbleBonusBall(numbers, bonusBall)) {
            System.out.println("보너스 볼은 당첨 번호와 달라야 합니다.");
            bonusBall = inputView.bonusBall();
        }

        LottoNumbers winningNumbers = new LottoNumbers(numbers);

        String resultInfo = lottoResult.result(lottoNumbers, winningNumbers);

        resultView.print();
        resultView.print(resultInfo);

    }

}
