package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.Lottos;

public class LottoView {

    private final LottoInputView lottoInputView;

    private final LottoOutputView lottoOutputView;

    public LottoView(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void buyLottoOutputView(int lottoCount, Lottos lottos) {
        lottoOutputView.buyLottoView(lottoCount, lottos);
    }

    public void lottoAnalysisOutputView(LottoAnalysisResult analysisResult){
        lottoOutputView.lottoAnalysisView(analysisResult);
    }

    public int amountInput(){
        return lottoInputView.amountInput();
    }

    public LastWinLotto lastWinLottoInput(){
        return lottoInputView.lastWinLottoInput();
    }


}
