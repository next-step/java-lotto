package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoOfNumber) {
        for (int i = 0; i < lottoOfNumber; i++) {
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

    public void findWinners(Winners winners, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            winners.findWinners(lotto, winningNumbers);
        }
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
