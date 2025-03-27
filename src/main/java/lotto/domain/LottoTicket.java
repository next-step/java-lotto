package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoTicket {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int NUMBER_LOWER_BOUND = 1;
    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> issue() {
        for(int i=0; i<6; i++) {
            numbers.add(generateNumber());
        }
        return numbers;
    }

    private static int generateNumber() {
        return RANDOM.nextInt(NUMBER_UPPER_BOUND) + NUMBER_LOWER_BOUND;
    }
}
