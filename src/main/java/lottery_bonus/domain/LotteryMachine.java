package lottery_bonus.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;

public final class LotteryMachine {

    private static final BigDecimal CRITERIA_PRICE = new BigDecimal(1000);
    private static final int LOTTERY_IDX_MIN = 0;
    private static final int LOTTERY_IDX_MAX = 6;
    private static final int LOTTERY_MIN_NUMBER = 1;
    private static final int LOTTERY_MAX_NUMBER = 45;

    private static LotteryMachine lotteryMachine = null;

    private LotteryMachine(){}

    private static class LazyHolder {
        public static final LotteryMachine INSTANCE = new LotteryMachine();
    }

    public static LotteryMachine getInstance(){
        return LazyHolder.INSTANCE;
    }

    public Lotteries issue(final int tickets) {
        return new Lotteries(Stream.generate(this::generateLottery)
                             .map(Lottery:: new)
                             .limit(tickets)
                             .collect(Collectors.toList()));
    }

    public List<Integer> generateLottery(){
        List<Integer> numbers = generateQuickPicks();

        return numbers.stream()
                      .sorted()
                      .collect(Collectors.toList());
    }

    public int purchase(final BigDecimal amount) {
        if(!validateAmount(amount)){
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요");
        }
        return amount.divide(CRITERIA_PRICE).intValue();
    }

    public boolean validateAmount(final BigDecimal amount){
        return amount.compareTo(CRITERIA_PRICE) >= LOTTERY_IDX_MIN;
    }

    private List<Integer> generateQuickPicks() {
        List<Integer> numbers = new ArrayList<>();
        rangeClosed(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER).forEach(numbers::add);
        shuffle(numbers);
        return numbers.subList(LOTTERY_IDX_MIN, LOTTERY_IDX_MAX);
    }
}
