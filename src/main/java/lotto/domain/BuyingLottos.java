package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyingLottos {
    private final static int START_NUMBER = 0;
    private final static int MIN_BUYABLE_PAYMENT = 1000;
    private Lottos lottos;
    private CashPayments cashPayments;
    private SelfInputCount selfInputCount;
    private BuyableCount buyableCount;
    
    public BuyingLottos(int cashPayments) {
        if (cashPayments < MIN_BUYABLE_PAYMENT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }
        this.cashPayments = new CashPayments(cashPayments);
        buyableCount = new BuyableCount(cashPayments / MIN_BUYABLE_PAYMENT);
    }
    
    public BuyingLottos(Lottos lottos, CashPayments cashPayments) {
        this.lottos = lottos;
        this.cashPayments = cashPayments;
    }
    
    public Lottos buyLottos() {
        lottos = new Lottos(makeLottoNumbers(Lottos.getBuyableCount(cashPayments)));
        return lottos;
    }
    
    private List<LottoNumbers> makeLottoNumbers(int count) {
        return IntStream.range(START_NUMBER, count)
          .mapToObj(i -> new LottoNumbers())
          .collect(Collectors.toList());
    }
    
    private List<LottoNumbers> makeLottoNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> new LottoNumbers(numbers))
                .collect(Collectors.toList());
    }
    
    public Lottos buyLottos(List<String> selfLottoNumbers) {
        if (!selfInputCount.isSame(selfLottoNumbers.size())) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_SELF_LOTTO_NUMBERS.message());
        }
        int selfLottoCount = selfInputCount.getSelfInputCount();
        List<LottoNumbers> selfLottos = makeLottoNumbers(selfLottoNumbers);
        List<LottoNumbers> authLottos = makeLottoNumbers(Lottos.getBuyableCount(cashPayments) - selfLottoCount);
        selfLottos.addAll(authLottos);
        lottos = new Lottos(selfLottos);
        return lottos;
    }
    
    
    public OwnPrize getOwnPrize(final WanLottoNumbers wanLottoNumbers) {
        return new OwnPrize(lottos.getWinNumbersCount(wanLottoNumbers), cashPayments);
    }
    
    public void setSelfInputCount(int selfInputCount) {
        if (buyableCount.isSmall(selfInputCount)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_INPUT_SELF_BUYING_COUNT.message());
        }
        this.selfInputCount = new SelfInputCount(selfInputCount);
    }
    
    @Override
    public String toString() {
        return lottos.toString();
    }
    
    public SelfInputCount getSelfInputCount() {
        return selfInputCount;
    }
}
