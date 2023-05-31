package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public void buyLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<LottoMatcher> matchResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(winningNumbers::match)
                .collect(Collectors.toList());
    }

    public int quantity() {
        return lottos.size();
    }

    public List<List<Integer>> result() {
        return lottos.stream()
                .map(lotto -> lotto.lottoNumbers()
                        .stream().map(LottoNumber::intValue)
                        .collect(Collectors.toList())).collect(Collectors.toList());

    }
}
