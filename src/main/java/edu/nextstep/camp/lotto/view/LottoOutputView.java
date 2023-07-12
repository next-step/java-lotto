package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.Lottos;

public interface LottoOutputView {

    void buyLottoView(int lottoCount, Lottos lottos);

    void lottoAnalysisView(LottoAnalysisResult analysisResult);
}
