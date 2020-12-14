package lotto.sevice;

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
        resultView.printLotto(lottoList);
        lottoList.setWinningNumbers(inputView.getWinningNumbers());
        lottoList.setBonusNumber(inputView.getBonusNumber());
        LottoRecord result = lottoService.lottoGame(lottoList, lottoList.getWinningNumbers(), lottoList.getBonusNumber());
        resultView.printRecord(result);
        
    }
    
}
