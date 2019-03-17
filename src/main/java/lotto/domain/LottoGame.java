package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private LottoGenerator lottoGenerator;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<BasicLotto> createLottos(int money) {
        int tryCount = convertMoneyToTryCount(money);
        List<BasicLotto> lottos = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottos.add(new BasicLotto(this.lottoGenerator.generate()));
        }
        return lottos;
    }

    private int convertMoneyToTryCount(int money) {
        if (money < 0)
            throw new IllegalArgumentException();

        return money / LOTTO_PRICE;
    }

    public void play(List<BasicLotto> lottos, WinningLotto winningLotto) {
        for (BasicLotto lotto : lottos) {
            checkMatchNumbers(lotto, winningLotto);
        }
    }

    private void checkMatchNumbers(BasicLotto lotto, WinningLotto winningLotto) {
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                lotto.matchCountUp();
            }
        }
    }
}
