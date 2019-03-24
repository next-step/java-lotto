package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(int lottoCount) {
        LottoGenerator generator = new LottoGenerator();
        this.lottos = new ArrayList<>();

        int i=0;
        while (i < lottoCount) {
            Lotto lotto = Lotto.generateLotto(generator.generateRandomNumber());
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
