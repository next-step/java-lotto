package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(Lotto lotto) {
        this.lottos = new ArrayList<>();
        this.lottos.add(lotto);
    }

    public boolean isCount(int expectedCount) {
        return this.lottos.size() == expectedCount;
    }

    public void createRandomLotto() {
        this.lottos.add(new Lotto());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lottoNumber : lottos) {
            stringBuilder.append(lottoNumber.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int compareWinNumber(List<Integer> winNumber) {
        int result = 0;
        for (Lotto lotto : lottos) {
            result = lotto.compareWinLottoNumber(winNumber);
        }
        return result;
    }
}
