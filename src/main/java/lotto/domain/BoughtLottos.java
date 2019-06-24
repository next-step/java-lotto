package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoughtLottos {
    private final static int START_NUMBER = 0;
    private Lottos lottos;
    private CashPayments cashPayments;
    
    public BoughtLottos() {}
    
    public BoughtLottos(Lottos lottos) {
        this.lottos = lottos;
    }
    
    public Lottos buyLottos(int cashPayment) {
        cashPayments = new CashPayments(cashPayment);
        int buyableCount = Lottos.getBuyableCount(cashPayment);
        lottos = new Lottos(IntStream.range(START_NUMBER, buyableCount)
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
