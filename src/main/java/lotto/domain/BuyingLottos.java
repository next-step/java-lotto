package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyingLottos {
    private final static int START_NUMBER = 0;
    private Lottos lottos;
    private CashPayments cashPayments;
    
    public BuyingLottos() {}
    
    public BuyingLottos(Lottos lottos, CashPayments cashPayments) {
        this.lottos = lottos;
        this.cashPayments = cashPayments;
    }
    
    public Lottos buyLottos(int cashPayment) {
        cashPayments = new CashPayments(cashPayment);
        lottos = new Lottos(IntStream.range(START_NUMBER, Lottos.getBuyableCount(cashPayment))
            .mapToObj(i -> new LottoNumbers())
            .collect(Collectors.toList()));
        return lottos;
    }
    
    public OwnPrize getOwnPrize(WinLottoNumbers winLottoNumbers) {
        OwnPrize ownPrize = new OwnPrize(lottos.getWinNumbersCount(winLottoNumbers), cashPayments);
        return ownPrize;
    }
    
    @Override
    public String toString() {
        return lottos.toString();
    }
}
