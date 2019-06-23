package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    static final int DEFAULT_PRICE = 1000;
    private final static int CANT_BUYABLE_COUNT = 0;
    private final static int START_NUMBER = 0;
    
    private List<Lotto> lottos;
    
    public Lottos() {
        this.lottos = new ArrayList<>();
    }
    
    public List<Lotto> buyLottos(int cashPayment) {
        int buyableCount = getBuyableCount(cashPayment);
        lottos = IntStream.range(START_NUMBER, buyableCount)
          .mapToObj(i -> new Lotto())
          .collect(Collectors.toList());
        return lottos;
    }
    
    private int getBuyableCount(int cashPayment) {
        int buyableCount = cashPayment / DEFAULT_PRICE;
        if (buyableCount <= CANT_BUYABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }
        
        return buyableCount;
    }
    
    @Override
    public String toString() {
        return lottos + "";
    }
}
