package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoOfNumber) {
        for (int i = 0; i < lottoOfNumber; i++) {
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
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
