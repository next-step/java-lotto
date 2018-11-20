package lotto.domain;

import lotto.LottoGame;

import java.util.List;

public class LottoDto {

    private final Lottos lottos;
    private final WinningLotto lotto;

    public LottoDto(final Lottos lottos, final WinningLotto lotto) {
        this.lottos = lottos;
        this.lotto = lotto;
    }

    public LottoDto(final LottoGame lottoGame, final WinningLotto lotto) {
        this.lottos = new Lottos(lottoGame.getLottos());
        this.lotto = lotto;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public Lotto getLotto() {
        return lotto.getLotto();
    }

    public int getBonus() {
        return lotto.getBonus();
    }

}
