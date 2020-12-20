package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final String MONEY_ERROR_MESSAGE = "money must be at least zero: %s";

    private final int size;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int size) {
        this.size = size;
    }

    public static Lottos purchase(int money) {
        checkArgument(money > 0, MONEY_ERROR_MESSAGE, money);

        Lottos lottos = new Lottos(money / LOTTO_PRICE);
        lottos.fillAutoRemaining();
        return lottos;
    }

    public void fillAutoRemaining() {
        int remain = size - lottos.size();
        for (int i = 0; i < remain; i++) {
            lottos.add(LottoGenerator.shuffleAndGet());
        }
    }

    public int size() {
        return lottos.size();
    }
}
