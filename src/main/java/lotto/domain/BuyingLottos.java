package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyingLottos {
    private final static int START_NUMBER = 0;
    private Lottos lottos;
    private CashPayments cashPayments;
    
    public BuyingLottos(int cashPayments) {
        CashPayments cashPayment = new CashPayments(cashPayments);
        lottos = buyLottos(cashPayment);
        this.cashPayments = new CashPayments(cashPayments);
    }
    
    public BuyingLottos(Lottos lottos, CashPayments cashPayments) {
        this.lottos = lottos;
        this.cashPayments = cashPayments;
    }
    
    
    
    public Lottos buyLottos(final CashPayments cashPayment) {
        lottos = new Lottos(IntStream.range(START_NUMBER, Lottos.getBuyableCount(cashPayment))
            .mapToObj(i -> new LottoNumbers())
            .collect(Collectors.toList()));
        return lottos;
    }
    
    public OwnPrize getOwnPrize(final WanLottoNumbers wanLottoNumbers) {
        return new OwnPrize(lottos.getWinNumbersCount(wanLottoNumbers), cashPayments);
    }
    
    @Override
    public String toString() {
        return lottos.toString();
    }
    
    public static boolean canBuyingSelfLotto(final int cashPayment, final int selfCount) {
        return selfCount <= Lottos.getBuyableCount(new CashPayments(cashPayment));
    }
}
