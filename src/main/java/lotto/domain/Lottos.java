package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lottos() {

    }

    public void createLotto() {
        Lotto lotto = new Lotto();
        lottos.add(lotto);
    }

    public List<Lotto> findLottos() {
        return lottos;
    }

    public List<Rank> getWinningList(List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> Rank.of(lotto.matchCount(winningNumbers), lotto.hasBonusNumber(bonusNumber)))
                .collect(Collectors.toList());
    }
}
