package lottoGame.model;

import lottoGame.model.factory.DefaultLottoFactory;
import lottoGame.model.factory.LottoFactory;

import java.util.List;

public class Lottery {
    private final List<Lotto> lottery;
    private final LottoFactory lottoFactory;

    public Lottery(int lotteryNum, LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
        this.lottery = create(lotteryNum);
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
}
