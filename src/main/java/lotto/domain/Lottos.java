package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this.lottos = init(amount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> init(int amount) {
        validate(amount);
        List<Lotto> lottos = new ArrayList<>();
        int num = amount / Lotto.PRICE;
        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private void validate(int amount) {
        if (amount < Lotto.PRICE) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int numberOfLotto() {
        return lottos.size();
    }
}
