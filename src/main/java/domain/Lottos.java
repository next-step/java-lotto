package domain;

import strategy.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int buyAmount, RandomNumberGenerator randomNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyAmount; i++) {
            lottos.add(new Lotto(randomNumberGenerator));
        }

        this.lottos = lottos;
    }

    public List<Lotto> getValue() {
        return this.lottos;
    }
}
