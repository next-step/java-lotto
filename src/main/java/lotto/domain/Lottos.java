package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void storeLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Ranking> judgeAllUserLotto(final WinningLotto winningLotto) {
        return lottos.stream()
            .map(lotto -> winningLotto.compareLotto(lotto))
            .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
