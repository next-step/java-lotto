package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.Lottos;

import java.util.List;

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

    public int manualLottoCountInput(){
        return lottoInputView.manualLottoCountInput();
    }

    public List<Lotto> manualLottoInput(int manualLottoCount){
        return lottoInputView.manualLottoInput(manualLottoCount);
    }


}
