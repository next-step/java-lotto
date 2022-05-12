package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos() { }

    public Lottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public void createLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findLottos() {
        return lottos;
    }

    public List<Rank> getWinningList(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> winningNumbers.findRank(lotto))
                .collect(Collectors.toList());
    }
}
