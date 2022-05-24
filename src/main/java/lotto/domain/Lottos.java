package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public Lottos(List<Lotto> lottoList, int numberOfLotto) {
        lottoList.forEach(lotto -> lottos.add(lotto));
        numberOfLotto = numberOfLotto - lottoList.size();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
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
