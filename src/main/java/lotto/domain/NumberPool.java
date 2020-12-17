package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPool {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private final List<Integer> numbers = new ArrayList<>();

    public NumberPool(){
        for(int i = 1; i <46; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(FROM_INDEX, TO_INDEX));
    }
}
