package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int CHOOSE_COUNT = 6;
    private static final List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER,MAX_NUMBER)
                                                        .boxed()
                                                        .collect(Collectors.toList());

    public static LotteryTicket generate() {
        Collections.shuffle(numbers);
        List<Integer> chosenNumbers = numbers.stream()
                                            .limit(CHOOSE_COUNT)
                                            .collect(Collectors.toList());
        Collections.sort(chosenNumbers);
        return new LotteryTicket(chosenNumbers);
    }
}
