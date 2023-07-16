package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoGame {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(final List<List<Integer>> lottos, final List<Integer> lottoNumbers, final int bonus) {
        this.lottos = toLottos(lottos);
        this.winningLotto = toWinningLotto(lottoNumbers, bonus);
    }

    public LottoResult result() {
        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }

    private Lottos toLottos(final List<List<Integer>> lottos) {
        List<Lotto> lottosContent = lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        return new Lottos(lottosContent);
    }

    private WinningLotto toWinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        final LottoNumber bonusLottoNumber = new LottoNumber(bonus);
        final Lotto lotto = new Lotto(lottoNumbers);

        return new WinningLotto(lotto, bonusLottoNumber);
    }
}
