package lotto.domain;

import lotto.strategy.LottoGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int lottoCount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottos = create(lottoCount, lottoGeneratorStrategy);
    }

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> create(int lottoCount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoGeneratorStrategy);
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoWinning result(WinningNumbers winningLotto) {
        LottoWinning winning = new LottoWinning();
        for (Lotto lotto : lottos) {
            winning.put(LottoRank.win(winningLotto.matches(lotto), winningLotto.hasBonus(lotto)));
        }
        return winning;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
