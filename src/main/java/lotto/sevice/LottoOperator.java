package lotto.sevice;

import java.util.List;

import lotto.domain.LottoList;
import lotto.domain.LottoRecord;
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
        LottoRecord result = lottoService.lottoGame(lottoList, winningNumbers);
        resultView.printRecord(result);
        
    }
    
}
