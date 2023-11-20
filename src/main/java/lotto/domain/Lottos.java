package lotto.domain;

import lotto.dto.WinningNumbersDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(int value) {
        this.lottos = new ArrayList<>();
        for (int game = 0; game < purchasableLottoCount(value); game++) {
            this.lottos.add(new Lotto());
        }
    }

    private int purchasableLottoCount(int value) {
        return value / Lotto.LOTTO_PRICE;
    }

    public Long totalWinningAmount(WinningNumbersDTO winningNumbersDTO) {
        Amount amount = new Amount();
        for (Lotto lotto : this.lottos) {
            amount.add(lotto.winningInfo(winningNumbersDTO).getWinningAmount());
        }
        return amount.amount();
    }

    public BigDecimal rateOfReturn(WinningNumbersDTO winningNumbersDTO) {
        Amount purchaseAmount = new Amount(this.lottos.size() * Lotto.LOTTO_PRICE);
        Amount winningAmount = new Amount(totalWinningAmount(winningNumbersDTO));
        return winningAmount.divide(purchaseAmount.amount(), 2);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public boolean isEmpty() {
        return lottos.size() == 0;
    }

    public int winningCorrectCount(WinningNumbersDTO winningNumbersDTO, Winning winning) {
        return (int) this.lottos.stream()
                .filter(lotto -> Winning.hasMatchingCounts(lotto.winningInfo(winningNumbersDTO), winning))
                .count();
    }
}
