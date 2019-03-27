package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(int lottoCount) {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        this.lottos = new ArrayList<>();

        int i=0;
        while (i < lottoCount) {
            Lotto lotto = new Lotto(generator.generateRandomNumber());
            lottos.add(lotto);
            i ++;
        }
    }

    public LottoResult playingLotto(WinningLotto winningLotto) {
        LottoResult lottoGameResult =  new LottoResult(lottos, winningLotto);
        return lottoGameResult;
    }

    public List<Lotto> lottos() {
        return lottos;
    }
}
