package domain;

import java.util.ArrayList;
import java.util.List;

import domain.strategy.LottoNumberStrategy;
import domain.strategy.ShuffleStrategy;

import static domain.Lotto.PRICE_PER_ONE;

public class LottoGenerator {
    private final LottoNumberStrategy lottoNumberStrategy;

    public final static int DRAW_NUMBER_COUNT = 6;

    public LottoGenerator() {
        this.lottoNumberStrategy = new ShuffleStrategy();
    }

    public LottoGenerator(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumberStrategy.generateNumbers(DRAW_NUMBER_COUNT));
    }

    public List<Lotto> createLottoBulk(int amount) {
        if (amount % PRICE_PER_ONE > 0) {
            throw new IllegalArgumentException("구입금액이 잘못되었습니다. amount : " + amount);
        }

        int buyCount = amount / PRICE_PER_ONE;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = this.createLotto();
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
