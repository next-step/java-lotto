package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = Lotto.of();
            lottos.add(lotto);
        }
    }

    private Lottos(List<Lotto> manualLottos, int remainNumberOfLotto) {
        lottos.addAll(manualLottos);

        for (int i = 0; i < remainNumberOfLotto; i++) {
            Lotto lotto = Lotto.of();
            lottos.add(lotto);
        }
    }

    public static Lottos createManualLottos(List<Lotto> manualLottos, int numberOfLotto) {
        int remainNumberOfLotto = numberOfLotto - manualLottos.size();
        return new Lottos(manualLottos, remainNumberOfLotto);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }

    public Map<Rank, Integer> selectRankType(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> Rank.selectType(winningNumbers.numberOfSame(lotto),
                        winningNumbers.isSameBonus(lotto)))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(getLottos(), lottos1.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottos());
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
