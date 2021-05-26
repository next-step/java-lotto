package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.LottoRanking;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void lotto(){

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoResult lottoResult = new LottoResult();

        int money = inputView.money();
        while (!lottoMachine.validateMoney(money)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            money = inputView.money();
        }

        int buyCount = lottoMachine.buyCount(money);
        List<LottoNumbers> lottoNumbers = lottoMachine.autoLottoNumbers(buyCount);
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        LottoNumbers winningNumbers = new LottoNumbers(numbers);

        resultView.print();
        Map<LottoRanking, Integer> lottoRankingResult = lottoResult.lottoResult(lottoNumbers, winningNumbers);
        float rateOfReturn = lottoResult.rateOfReturn(money);
        resultView.print(lottoRankingResult, rateOfReturn);
    }

}
