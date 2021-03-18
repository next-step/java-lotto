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

    public void start(){
        int money = inputView.money();
        int buyCount = buyCount(money);

        resultView.print(buyCount);

        List<LottoNumbers> lottoNumbers = lottoMachine.lottoNumbers(buyCount);

        resultView.print(lottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(inputView.winningNumbers());

        String resultInfo = lottoResult.result(lottoNumbers, winningNumbers);
        resultView.print();
        resultView.print(resultInfo);
    }

    public int buyCount(int buyMoney) {
        return buyMoney / LottoConstants.LOTTO_PRICE;
    }



}
