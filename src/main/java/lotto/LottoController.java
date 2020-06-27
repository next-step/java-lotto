package lotto;

import lotto.domain.*;
import lotto.utils.LottoShuffle;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoGame lottoGame;
    private List<Lotto> lottos;

    public LottoController(LottoGame lottoGame, List<Lotto> selectLottos) {

        lottos = new ArrayList<Lotto>();
        lottos.addAll(selectLottos);
        this.lottoGame = lottoGame;
    }

    public void createLotto() {

        for (int i = 0; i < lottoGame.getAutoGame(); i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        Output.printBuyLottoNumber(lottos);

    }

    public WinningLottoResult matchLotto(WinningLotto winningLotto) {

        WinningLottoResult lottoResult = new WinningLottoResult();
        for (Lotto lotto : lottos) {
            int count = lotto.matchCount(winningLotto.getWinninglotto());
            lottoResult.match(count, lotto.isContain(winningLotto.getBonusNumber()));
        }
        return lottoResult;
    }

}
