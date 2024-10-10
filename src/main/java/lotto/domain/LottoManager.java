package lotto.domain;

import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;
import lotto.dto.WinningNumbersDTO;

public class LottoManager {
    private PurchasedLottos purchasedLottos;
    private Lotto winningLotto;

    LottoManager(){

    }

    public static LottoManager newInstance() {
        return new LottoManager();
    }

    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
    }

    public PurchasedLottosDTO listPurchasedLottos() {
    }

    public void decideWinningNumbers(WinningNumbersDTO winningNumbers) {
    }

    public LottoStatisticsDTO getStatistics() {
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
