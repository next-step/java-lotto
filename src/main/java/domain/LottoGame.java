package domain;

import strategy.RandomNumberGenerator;
import util.CalculatorUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private final int buyAmount;

    public LottoGame(int buyPrice) {
        this.buyAmount = CalculatorUtil.divide(buyPrice, LOTTO_PRICE);
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public List<Lotto> issue(RandomNumberGenerator randomNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < this.buyAmount; i++) {
            lottos.add(new Lotto(randomNumberGenerator));
        }

        return lottos;
    }
}
