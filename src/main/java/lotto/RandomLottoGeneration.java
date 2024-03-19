package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RandomLottoGeneration implements LottoGeneration {
    private final static List<Integer> numbers = new ArrayList<>();
    {
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> integerList = numbers.subList(0, 6);
        Collections.sort(integerList);

        return integerList;
    }
}
