package lottery.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketIssuer {

    private static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(1, 45)
                                                              .boxed()
                                                              .collect(Collectors.toList());


    public LotteryTicket issue(int money) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lottery> lotteryList = new ArrayList<>();

        for(int i = 0; i < money / 1000; i++) {
            lotteryList.add(new Lottery(new ArrayList<>(numbers)));
        }

        return new LotteryTicket(lotteryList);
    }
}
