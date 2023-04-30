package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseAmount) {
        this(purchaseAmount, new NumberGenerator());
    }

    public Lottos(int purchaseAmount, NumberGenerator numberGenerator) {
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(numberGenerator.generateNumbers()));
        }
    }

    public int getAmount() {
        return lottos.size();
    }
}
