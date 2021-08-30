package lottery_auto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;

public final class LotteryMachine {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);
    private static final int LOTTO_IDX_ZERO = 0;
    private static final int LOTTO_IDX = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

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
        List<Integer> numbers = shuffleNumber(disposeNumber());

        return new ArrayList<>(numbers.subList(LOTTO_IDX_ZERO, LOTTO_IDX))
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int purchase(final BigDecimal amount) {
        if(!validate(amount)){
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요");
        }
        return amount.divide(LOTTO_PRICE).intValue();
    }

    public boolean validate(final BigDecimal amount){
        return amount.compareTo(LOTTO_PRICE) >= LOTTO_IDX_ZERO;
    }

    private List<Integer> disposeNumber() {
        List<Integer> numbers = new ArrayList<>();
        rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).forEach(numbers::add);
        return numbers;
    }

    private List<Integer> shuffleNumber(List<Integer> numbers) {
        shuffle(numbers);
        return numbers;
    }

}
