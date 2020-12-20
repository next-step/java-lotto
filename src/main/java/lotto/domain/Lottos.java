package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkArgument;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final String MONEY_ERROR_MESSAGE = "money must be at least zero: %s";
    private static final String MONEY_UNIT_MESSAGE = "Only %s won units are allowed: %s";

    private final int size;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int size) {
        this.size = size;
    }

    public static Lottos purchase(int money) {
        checkArgument(money > 0, MONEY_ERROR_MESSAGE, money);
        checkArgument(money % LOTTO_PRICE == 0, MONEY_UNIT_MESSAGE, LOTTO_PRICE, money);

        Lottos lottos = new Lottos(money / LOTTO_PRICE);
        lottos.fillAutoRemaining();
        return lottos;
    }

    public void fillAutoRemaining() {
        int remain = size - lottos.size();
        for (int i = 0; i < remain; i++) {
            add(LottoGenerator.shuffleAndGet());
        }
    }

    public int size() {
        return lottos.size();
    }

    public void forEachLotto(Consumer<Lotto> lottoConsumer) {
        for (Lotto lotto : lottos) {
            lottoConsumer.accept(lotto);
        }
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult(size * LOTTO_PRICE);
        for (Lotto lotto : lottos) {
            LottoRanking ranking = winningLotto.matching(lotto);
            result.addRanking(ranking);
        }
        return result;
    }
}
