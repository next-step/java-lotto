package lotto.domain;

public final class LottoGame {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(
            final Lottos manualLottos,
            final Lottos autoLottos,
            final Lotto lottoNumbers,
            final LottoNumber bonus
    ) {
        this.lottos = manualLottos.merge(autoLottos);
        this.winningLotto = new WinningLotto(lottoNumbers, bonus);
    }

    public LottoResult result() {
        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }
}
