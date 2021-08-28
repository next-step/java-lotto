package lottery_auto.domain;

import lottery_auto.strategy.LotteryStrategy;
import lottery_auto.strategy.LotteryStrategyImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LotteryMachine {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);
    private static final int COMPARISON_CRITERIA = 0;
    private static final LotteryStrategy LOTTO_STRATEGY = new LotteryStrategyImpl();

    private static LotteryMachine lotteryMachine = null;

    private LotteryMachine(){}

    private static class LazyHolder {
        public static final LotteryMachine INSTANCE = new LotteryMachine();
    }

    public static LotteryMachine getInstance(){
        return LazyHolder.INSTANCE;
    }

    public Lotteries issue(final int tickets) {
        return new Lotteries(Stream.generate(this::generateNumber)
                             .map(Lottery :: new)
                             .limit(tickets)
                             .collect(Collectors.toList()));
    }

    public List<Integer> generateNumber(){
        return LOTTO_STRATEGY.generate();
    }

    public int purchase(final BigDecimal amount) {
        if(!validate(amount)){
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요");
        }
        return amount.divide(LOTTO_PRICE).intValue();
    }

    public boolean validate(final BigDecimal amount){
        return amount.compareTo(LOTTO_PRICE) >= COMPARISON_CRITERIA;
    }

}
