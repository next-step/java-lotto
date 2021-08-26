package lottery_auto.domain;

import lottery_auto.strategy.LotteryStrategy;
import lottery_auto.strategy.LotteryStrategyImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LotteryMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final LotteryStrategy LOTTO_STRATEGY = new LotteryStrategyImpl();

    private static LotteryMachine lotteryMachine = null;

    private LotteryMachine(){}

    public static synchronized LotteryMachine getInstance(){
        if(lotteryMachine == null){
            lotteryMachine = new LotteryMachine();
        }
        return lotteryMachine;
    }

    public Lotteries issue(final int tickets) {
        return new Lotteries(Stream.generate(LOTTO_STRATEGY::generate)
                             .map(Lottery :: new)
                             .limit(tickets)
                             .collect(Collectors.toList()));
    }

    public int purchase(final int amount) {
        if(!validate(amount)){
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요");
        }
        return amount / LOTTO_PRICE;
    }

    public boolean validate(final int amount){
        return amount >= LOTTO_PRICE;
    }

}
