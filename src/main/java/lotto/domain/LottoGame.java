package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoGame {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(
            final List<List<Integer>> manualLottos,
            final List<List<Integer>> autoLottos,
            final List<Integer> lottoNumbers,
            final int bonus
    ) {
        this.lottos = toLottos(manualLottos, autoLottos);
        this.winningLotto = toWinningLotto(lottoNumbers, bonus);
    }

    public LottoResult result() {
        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }

    private Lottos toLottos(final List<List<Integer>> manualLottos, final List<List<Integer>> autoLottos) {
        final List<Lotto> mergedLottos =
                Stream.concat(
                                manualLottos.stream().map(Lotto::new),
                                autoLottos.stream().map(Lotto::new)
                        )
                        .collect(Collectors.toList());

        return new Lottos(mergedLottos);
    }

    private WinningLotto toWinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        final LottoNumber bonusLottoNumber = new LottoNumber(bonus);
        final Lotto lotto = new Lotto(lottoNumbers);

        return new WinningLotto(lotto, bonusLottoNumber);
    }
}
