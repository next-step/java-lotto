package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int inputMoney) {
        int lottoNum = inputMoney / Lotto.price;
        for (int i = 0; i < lottoNum; i++) {
            lottos.add(new Lotto());
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Integer> numbers(int i) {
        return lottos.get(i).pick();
    }

    public void matching(String numbers) {
    }

    public double moneyProfitRate() {
        return 0.0;
    }
}
