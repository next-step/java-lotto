package lottoGame.model;

import lottoGame.model.factory.DefaultLottoFactory;
import lottoGame.model.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private final List<Lotto> lottery = new ArrayList<>();
    private final LottoFactory lottoFactory;

    public Lottery(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public int getSize() {
        return lottery.size();
    }

    public List<Lotto> create(int lotteryNum) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(lottoFactory.createLotto());
        }
        return lottery;
    }

    public int calculate(List<Integer> winningNumer) {
        return lottery.stream().map(
                lotto -> {
                    if (lotto.isContain(winningNumer) == 3) {
                        return 5000;
                    }
                    if (lotto.isContain(winningNumer) == 4) {
                        return 50000;
                    }
                    if (lotto.isContain(winningNumer) == 5) {
                        return 1500000;
                    }
                    if (lotto.isContain(winningNumer) == 6) {
                        return 2000000000;
                    }
                    return 0;
                }).findFirst().get();
    }
}
