package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPool {
    private List <Integer> numbers = new ArrayList<>();

    public NumberPool(){
        for(int i = 1; i <46; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 7);
    }
}
