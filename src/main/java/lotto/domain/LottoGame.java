package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final Lottos lottos;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> lottos() {
        return lottos.result();
    }

    public LottoScore score(WinningNumbers winningNumbers) {
        List<LottoMatcher> lottoMatchers = lottos.matchResult(winningNumbers);
        return new LottoScore(lottoMatchers);
    }

    public int quantity() {
        return lottos.quantity();
    }

    public void buyAutoLotto(int lottoCount) {
        lottos.buyLotto(lottoCount);
    }

    public void buyManualLotto(List<String> lottos) {
        lottos.stream()
                .map(lotto -> Arrays.stream(lotto.split(",\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .forEach(numbers -> this.lottos.buyLotto(lottos));
    }
}
