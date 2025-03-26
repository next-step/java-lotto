package step2.lotto.game;

import java.util.ArrayList;
import java.util.List;
import step2.lotto.domain.Generator;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.Lottos;
import step2.lotto.domain.Statistic;

public class Game {

    private final int LOTTO_PRICE = 1000;
    private int gameCount;
    private final Generator generator;
    private Lottos lottos;

    public Game() {
        this.generator = new Generator();
    }

    public Lottos createLottos(int paidMoney) {
        calculateLottoCount(paidMoney);
        RollingLotto();
        return lottos;
    }

    public void calculateLottoCount(int paidMoney) {
        gameCount = paidMoney / LOTTO_PRICE;
    }

    public void RollingLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lotto.add(new Lotto(generator.generate()));
        }
        this.lottos = new Lottos(lotto);
    }

    public Statistic play(Lotto winningLotto) {
        Statistic stat = new Statistic();
        stat.calculate(lottos, winningLotto);
        return stat;
    }
}
