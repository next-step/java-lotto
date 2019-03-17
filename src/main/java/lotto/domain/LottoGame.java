package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_REWARD_MATCH_COUNT = 3;

    private int tryCount;
    private LottoGenerator lottoGenerator;
    private List<BasicLotto> lottos;
    private int reward = 0;

    public LottoGame(int money, LottoGenerator lottoGenerator) {
        this.tryCount = createTryCount(money);
        this.lottoGenerator = lottoGenerator;
    }

    private int createTryCount(int money) {
        if (money < 0)
            throw new IllegalArgumentException();

        return money / LOTTO_PRICE;
    }

    public List<BasicLotto> createLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < this.tryCount; i++) {
            lottos.add(new BasicLotto(this.lottoGenerator.generate()));
        }
        return lottos;
    }

    public void play(WinningLotto winningLotto) {
        for (BasicLotto lotto : lottos) {
            checkMatchNumbers(lotto, winningLotto);
            addReward(lotto.getMatchCount());
        }
    }

    private void checkMatchNumbers(BasicLotto lotto, WinningLotto winningLotto) {
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                lotto.matchCountUp();
            }
        }
    }

    private void addReward(int matchCount) {
        if (matchCount >= MIN_REWARD_MATCH_COUNT) {
            reward += Rank.valueOf(matchCount).getWinningMoney();
        }
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public int getReward() {
        return this.reward;
    }
}
