package lotto.sevice;

import lotto.domain.LottoList;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoOperator {
    LottoService lottoService = new LottoService();
    
    InputView inputView;
    ResultView resultView;

    public LottoOperator(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;

    }

    public void operator(){
        int money = inputView.getMoney();
        LottoList lottoList = lottoService.issueLotto(money);
        int[] winningNumbers = inputView.getWinningNumbers();
        LottoList winningList = lottoService.lottogame(lottoList, winningNumbers);
    }
    
}
