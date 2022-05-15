package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoOfNumber) {
        for (int i = 0; i < lottoOfNumber; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public void findWinners(WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            winningNumbers.findWinners(lotto);
        }
    }

    @Override

    public String toString() {
        String resultString = "";
        for (Lotto lotto : lottos) {
            resultString += lotto.toString() + "\n";
        }
        return resultString;
    }
}
