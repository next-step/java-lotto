package step2.lotto.game;

import java.util.ArrayList;
import java.util.List;
import step2.lotto.domain.LottoNumberGenerator;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.Lottos;
import step2.lotto.domain.Statistic;

public class Game {

    public static final int LOTTO_PRICE = 1000;
    private int gameCount;
    private final LottoNumberGenerator generator;
    private Lottos lottos;

    public Game() {
        this.generator = new LottoNumberGenerator();
    }

    public Lottos createLottos(int paidMoney) {
        calculateLottoCount(paidMoney);
        rollingLotto();
        return lottos;
    }

    public void calculateLottoCount(int paidMoney) {
        gameCount = paidMoney / LOTTO_PRICE;
    }

    public void rollingLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lotto.add(new Lotto(generator.generate()));
        }
        this.lottos = new Lottos(lotto);
    }

    public Statistic play(List<Integer> winningLottoNumbers) {
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        Statistic stat = new Statistic();
        stat.calculate(lottos, winningLotto);
        return stat;
    }

}
