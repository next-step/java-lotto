package lottoGame;

import java.util.List;

public class Lottery {
    private final List<Lotto> lottery;

    public Lottery(int lotteryNum) {
        this.lottery = create(lotteryNum);
    }

    public int getSize() {
        return lottery.size();
    }

    public List<Lotto> create(int lotteryNum) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(new Lotto());
        }
        return lottery;
    }
}
