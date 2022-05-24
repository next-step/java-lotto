package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = Lotto.of();
            lottos.add(lotto);
        }
    }

    private Lottos(List<Lotto> lottoList, int numberOfLotto) {
        lottoList.forEach(lotto -> lottos.add(lotto));
        int remainNumberOfLotto = numberOfLotto - lottoList.size();

        for (int i = 0; i < remainNumberOfLotto; i++) {
            Lotto lotto = Lotto.of();
            lottos.add(lotto);
        }
    }

    public static Lottos createAutoLottos(int numberOfLotto) {
        return new Lottos(numberOfLotto);
    }

    public static Lottos createManualLottos(List<Lotto> lottoList, int numberOfLotto) {
        return new Lottos(lottoList, numberOfLotto);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }

    public List<Rank> selectRankType(WinningNumbers winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = winningNumbers.numberOfSame(lotto);
            ranks.add(Rank.selectType(count, winningNumbers.isSameBonus(lotto)));
        }
        return ranks;
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
