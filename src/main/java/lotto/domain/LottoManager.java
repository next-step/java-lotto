package lotto.domain;

import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    private PurchasedLottos purchasedLottos;
    private Lotto winningLotto;

    LottoManager(){}

    public static LottoManager newInstance() {
        return new LottoManager();
    }

    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = price / LOTTO_PRICE;
        List<Lotto> buyingLottos = new ArrayList<>();
        for (int i = 0; i < buyingCount; i++) {
            buyLotto(selectionStrategy, buyingLottos);
        }
        this.purchasedLottos = PurchasedLottos.valueOf(buyingLottos);
    }

    private static void buyLotto(LottoNumberSelectionStrategy selectionStrategy, List<Lotto> buyingLottos) {
        buyingLottos.add(selectionStrategy.select());
    }

    public PurchasedLottosDTO listPurchasedLottos() {
        return PurchasedLottosDTO.valueOf(this.purchasedLottos);
    }

    public void decideWinningNumbers(WinningNumbersDTO winningNumbers) {
        List<Integer> winningNumberList = winningNumbers.getWinningNumbers();
        this.winningLotto = Lotto.valueOf(winningNumberList);
    }

    public LottoStatisticsDTO getStatistics() {
        List<Lotto> purchasedLottos = this.purchasedLottos.value();
        Map<Integer, Integer> matchCount = new HashMap<>();
        for(Lotto purchasedLotto: purchasedLottos) {
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
