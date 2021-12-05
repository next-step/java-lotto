package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> sellTo(Person person) {
        List<Lotto> lottos = new ArrayList<>();
        int num = person.getAmount() / LOTTO_PRICE;
        for (int i = 0; i < num; i++) {
            lottos.add(person.buy());
        }
        return lottos;
    }
}
