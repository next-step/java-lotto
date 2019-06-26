package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int DEFAULT_PRICE = 1000;
    private final static int CANT_BUYABLE_COUNT = 0;
    
    private List<LottoNumbers> lottos;
    
    public Lottos() {
        this(new ArrayList<>());
    }
    
    public Lottos(final List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }
    
    public static int getBuyableCount(final CashPayments cashPayment) {
        final int buyableCount = cashPayment.getBuyableCount(DEFAULT_PRICE);
        if (buyableCount <= CANT_BUYABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }

        return buyableCount;
    }
    
    WinNumbersCount getWinNumbersCount(final WanLottoNumbers wanLottoNumbers) {
        WinNumbersCount winNumbersCount = new WinNumbersCount();
        lottos.forEach(lotto -> {
            final int matchedNumberCount = wanLottoNumbers.getMatchedNumberCount(lotto);
            final boolean isMatchedBonus = wanLottoNumbers.isMatchedBonus(lotto);
            winNumbersCount.addWinCount(matchedNumberCount, isMatchedBonus);
        });
        return winNumbersCount;
    }
    
    public int getLottoSize() {
        return lottos.size();
    }
    
    public boolean hasLottoNumbers(LottoNumbers lottoNumbers) {
        return lottos.stream()
                .anyMatch(numbers -> numbers.isEqualsTo(lottoNumbers));
    }
    
    @Override
    public String toString() {
        return (lottos + "").replace("[", "").replace("]", "");
    }
}
