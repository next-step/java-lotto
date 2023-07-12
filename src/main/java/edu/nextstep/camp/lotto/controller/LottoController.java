package edu.nextstep.camp.lotto.controller;

import edu.nextstep.camp.lotto.domain.LottoFactory;
import edu.nextstep.camp.lotto.domain.LottoGame;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.view.LottoOutputView;

import java.util.Arrays;

public class LottoController {

    private final LottoGame lottoGame;
    private final LottoOutputView lottoOutputView;

    public LottoController(LottoFactory lottoFactory, LottoOutputView lottoOutputView) {
        this.lottoGame = new LottoGame(lottoFactory);
        this.lottoOutputView = lottoOutputView;
    }

    public Lottos buyLottos(String amount) {
        return this.buyLottos(Integer.parseInt(amount));
    }

    public Lottos buyLottos(int amount) {
        Lottos lottos = lottoGame.buyLotto(amount);

        lottoOutputView.buyLottoView(amount, lottos);

        return lottos;
    }

    public void analysisLotto(Lottos lottos, String... lottoNumbers) {
        this.analysisLotto(lottos, Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .toArray(Integer[]::new)
        );
    }

    public void analysisLotto(Lottos lottos, Integer... lottoNumbers) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또가 null 입니다.");
        }

        lottoOutputView.lottoAnalysisView(lottos.analysis(lottoNumbers));
    }
}
