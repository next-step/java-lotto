package lotto.domain;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottos.add(Lotto.createQuickPick());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottos.size(); ++i) {
            this.lottos.add(lottos.get(i));
        }
    }

    public Map<Division, Integer> compareNumbers(Lotto comparingLotto) {
        Map<Division, Integer> winnerCounts = Division.getRankCounts();
        List<Division> divisions = new ArrayList<>();
        for (Lotto lotto: lottos) {
            Division division = lotto.compareLotto(comparingLotto);
            divisions.add(division);
        }
        divisions.removeAll(Collections.singletonList(Division.LOSE));

        for (Division division: divisions) {
            winnerCounts.put(division, winnerCounts.getOrDefault(division, 0) + 1);
        }
        return winnerCounts;
    }

    public Map<Division, Integer> compareNumbers(Lotto comparingLotto, LottoNumber bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(comparingLotto, bonusNumber);
        Map<Division, Integer> winnerCounts = Division.getRankCounts();
        List<Division> divisions = new ArrayList<>();
        for (Lotto lotto: lottos) {
            Division division = lotto.compareLotto(winningLotto);
            divisions.add(division);
        }
        divisions.removeAll(Collections.singletonList(Division.LOSE));

        for (Division division: divisions) {
            winnerCounts.put(division, winnerCounts.getOrDefault(division, 0) + 1);
        }
        return winnerCounts;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
