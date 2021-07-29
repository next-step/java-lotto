package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(Money money, Numbers numbers) {
        int size = money.countLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(numbers));
        }
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }
}
