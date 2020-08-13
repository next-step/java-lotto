package domain;

import strategy.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int buyAmount, NumberGenerator randomNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyAmount; i++) {
            lottos.add(new Lotto(randomNumberGenerator));
        }

        this.lottos = lottos;
    }

    public List<Lotto> getValue() {
        return this.lottos;
    }

    public LottoPrize getPrizes(List<Integer> winningNumbers) {
        LottoPrize prize = new LottoPrize();
        for (Lotto lotto : lottos) {
            prize.win(lotto.hasWinningNumber(winningNumbers));
        }

        return prize;
    }
}
