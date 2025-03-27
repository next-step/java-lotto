package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoTicket {
    private static final Random RANDOM = new Random();
    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> issue() {
        for(int i=0; i<6; i++) {
            numbers.add(generateNumber());
        }
        return numbers;
    }

    private static int generateNumber() {
        return RANDOM.nextInt(45);
    }
}
