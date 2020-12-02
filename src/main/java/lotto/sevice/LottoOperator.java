package lotto.sevice;

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
        lottoService.IssueLotto();
    }
    
}
