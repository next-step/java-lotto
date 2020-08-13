package domain;

import strategy.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int LOTTO_NUMBERS = 6;
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

    public LottoResults getPrizes(List<Integer> winningNumbers) {
        if(winningNumbers.size() != LOTTO_NUMBERS) {
            throw new RuntimeException();
        }

        LottoResults prize = new LottoResults();
        for (Lotto lotto : lottos) {
            prize.win(lotto.hasWinningNumber(winningNumbers));
        }

        return prize;
    }
}
