package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_BOUND = 45;

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> ticket = new ArrayList<Integer>();

        for (int bound = 1; bound <= LOTTO_NUMBER_BOUND; bound++) {
            numbers.add(bound);
        }
        Collections.shuffle(numbers);
        for (int index = 0; index < LOTTO_NUMBER_COUNT; index++) {
            ticket.add(numbers.get(index));
        }

        Collections.sort(ticket);
        return ticket;
    }
}
