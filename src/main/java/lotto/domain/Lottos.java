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

    public void findWinners(Winners winners) {
        for (Lotto lotto : lottos) {
            winners.findWinners(lotto);
        }
    }

    @Override

    public String toString() {
        String resultString = "";

        /*
        for (Lotto lotto : lottos) {
            resultString += lotto.toString() + "\n";
        }

         */
        return lottos.toString();
    }
}
