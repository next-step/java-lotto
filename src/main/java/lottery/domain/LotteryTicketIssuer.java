package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryTicketIssuer {

    private static final int LOTTERY_SIZE = 6;
    private static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(1, 45)
                                                              .boxed()
                                                              .collect(Collectors.toList());
    static final int LOTTERY_PRICE = 1000;

    private LotteryTicketIssuer() {}

    public static LotteryTicket issue(int money) {
        return Stream.generate(LotteryTicketIssuer::generateLottery)
                     .limit(money / LOTTERY_PRICE)
                     .collect(Collectors.collectingAndThen(Collectors.toList(), LotteryTicket::new));
    }

    private static Lottery generateLottery() {
        List<Integer> numbers = new ArrayList<>(NUMBER_LIST);

        Collections.shuffle(numbers);

        List<Integer> pickedList = numbers.subList(0, LOTTERY_SIZE)
                                          .stream()
                                          .sorted()
                                          .collect(Collectors.toList());

        return new Lottery(pickedList);
    }

}
