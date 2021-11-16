package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketGenerator {

    private final static int NUMBER_START = 1;
    private final static int NUMBER_END = 25;
    private final static int CHOOSE_COUNT = 6;
    private final static List<Integer> numbers = IntStream.rangeClosed(NUMBER_START,NUMBER_END)
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
