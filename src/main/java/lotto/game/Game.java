package lotto.game;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.Lottos;
import lotto.domain.Statistic;
import lotto.domain.WinLottoNumber;

public class Game {

    public static final int LOTTO_PRICE = 1000;
    private int gameCount;
    private Lottos lottos;

    public Game(int paidMoney) {
        createLottos(paidMoney);
    }

    private void createLottos(int paidMoney) {
        calculateLottoCount(paidMoney);
        rollingLotto();
    }

    public Lottos lottos() {
        return lottos;
    }

    public void calculateLottoCount(int paidMoney) {
        gameCount = paidMoney / LOTTO_PRICE;
    }

    public void rollingLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lotto.add(new Lotto(LottoGenerator.generate()));
        }
        this.lottos = new Lottos(lotto);
    }

    public Statistic play(List<LottoNum> winningLottoNumbers, int bonusNumber) {
        WinLottoNumber winNumber = new WinLottoNumber(
            new Lotto(winningLottoNumbers), new LottoNum(bonusNumber));
        return new Statistic(lottos, winNumber);
    }

}
