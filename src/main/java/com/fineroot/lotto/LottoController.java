package com.fineroot.lotto;

import com.fineroot.lotto.entity.LottoStore;
import com.fineroot.lotto.view.InputView;

public class LottoController {

    LottoStore lottoStore;

    public LottoController(LottoStore lottoStore){
        this.lottoStore = lottoStore;
    }

    public void lotto(){
        InputView inputView = new InputView(lottoStore);
        inputView.draw();
    }
}
