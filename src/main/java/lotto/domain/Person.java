package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int amount;
    private List<Lotto> lottos = new ArrayList<>();

    public Person(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Lotto buy() {
        return new Lotto(LottoNumber.of());
    }
}
