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
    private final int manualCount;
    private final int autoCount;
    private Lottos lottos;

    public Game(int paidMoney, int manualCount) {
        this.manualCount = manualCount;
        this.autoCount = (paidMoney / LOTTO_PRICE) - manualCount;
    }

    public Lottos lottos() {
        return lottos;
    }

    public void generateLottos(List<Lotto> manualLottoNumbersList) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "장을 구매했습니다.");
        List<Lotto> allLottos = new ArrayList<>(manualLottoNumbersList);
        for (int i = 0; i < autoCount; i++) {
            allLottos.add(new Lotto(LottoGenerator.generate()));
        }
        this.lottos = new Lottos(allLottos);
    }

    public Statistic play(List<LottoNum> winningLottoNumbers, int bonusNumber) {
        WinLottoNumber winNumber = new WinLottoNumber(
            new Lotto(winningLottoNumbers), new LottoNum(bonusNumber));
        return new Statistic(lottos, winNumber);
    }

}
