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
    
    private BuyingLottos(Builder builder) {
        this.cashPayments = builder.cashPayments;
        this.selfInputCount = builder.selfInputCount;
        this.lottos = builder.lottos;
    }
    
    public static class Builder {
        private CashPayments cashPayments;
        private SelfInputCount selfInputCount;
        private Lottos lottos;
        private BuyableCount buyableCount;
    
        public Builder setCashPayments(int cashPayments) {
            if (cashPayments < MIN_BUYABLE_PAYMENT) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
            }
            this.cashPayments = new CashPayments(cashPayments);
            buyableCount = new BuyableCount(cashPayments / MIN_BUYABLE_PAYMENT);
            return this;
        }
        
        public Builder setSelfInputCount(int selfInputCount) {
            if (buyableCount.isSmall(selfInputCount)) {
                throw new IllegalArgumentException(ErrorMessage.OVER_INPUT_SELF_BUYING_COUNT.message());
            }
            this.selfInputCount = new SelfInputCount(selfInputCount);
            return this;
        }
    
        public Builder buyLottos(List<String> selfLottoNumbers) {
            if (!selfInputCount.isSame(selfLottoNumbers.size())) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_SELF_LOTTO_NUMBERS.message());
            }
            int selfLottoCount = selfInputCount.getSelfInputCount();
            List<LottoNumbers> selfLottos = makeLottoNumbers(selfLottoNumbers);
            selfLottos.addAll(makeLottoNumbers(Lottos.getBuyableCount(cashPayments) - selfLottoCount));
            lottos = new Lottos(selfLottos);
            return this;
        }
        
        public BuyingLottos build() {
            return new BuyingLottos(this);
        }
    }
    
    private static List<LottoNumbers> makeLottoNumbers(int count) {
        return IntStream.range(START_NUMBER, count)
            .mapToObj(i -> new LottoNumbers())
            .collect(Collectors.toList());
    }
    
    private static List<LottoNumbers> makeLottoNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumbers::new)
            .collect(Collectors.toList());
    }
    
    public OwnPrize getOwnPrize(final WanLottoNumbers wanLottoNumbers) {
        return new OwnPrize(lottos.getWinNumbersCount(wanLottoNumbers), cashPayments);
    }
    
    public boolean hasLottoNumbers(String lottoNumbers) {
        return lottos.hasLottoNumbers(new LottoNumbers(lottoNumbers));
    }
    
    public boolean isEqualsLottoSize(int size) {
        return lottos.getLottoSize() == size;
    }
    
    @Override
    public String toString() {
        return lottos.toString();
    }
    
    public SelfInputCount getSelfInputCount() {
        return selfInputCount;
    }
}
