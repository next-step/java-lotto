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

    public Lottos(List<Lotto> lottoList, int lottoOfNumber) {
        lottoList.forEach(lotto -> lottos.add(lotto));
        lottoOfNumber = lottoOfNumber - lottoList.size();

        for (int i = 0; i < lottoOfNumber; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void findWinners(Winners winners) {
        for (Lotto lotto : lottos) {
            winners.findWinners(lotto);
        }
    }


    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
