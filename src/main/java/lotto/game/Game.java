package lotto.game;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.Lottos;
import lotto.domain.Statistic;
import lotto.domain.WinLottoNumber;
import lotto.dto.GameRequest;

public class Game {

    public static final int LOTTO_PRICE = 1000;
    private Lottos lottos;

    public Game() {
    }

    public Lottos createLottos(GameRequest gameRequest) {
        int paidMoney = gameRequest.getPaidMoney();
        int manualCount = gameRequest.getManualCount();
        List<Lotto> manualLottoNumbersList = gameRequest.getManualLottoNumbers();
        List<Lotto> autoLottoNumbers = autoLottoNumbers(paidMoney / LOTTO_PRICE - manualCount);
        lottos = new Lottos(manualLottoNumbersList, autoLottoNumbers);
        return lottos;
    }

    private List<Lotto> autoLottoNumbers(int autoCount) {
        List<Lotto> autoLottoNumbers = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            autoLottoNumbers.add(new Lotto(LottoGenerator.generate()));
        }
        return autoLottoNumbers;
    }

    public Statistic play(List<LottoNum> winningLottoNumbers, int bonusNumber) {
        WinLottoNumber winNumber = new WinLottoNumber(
            new Lotto(winningLottoNumbers), new LottoNum(bonusNumber));
        return new Statistic(lottos, winNumber);
    }

}
