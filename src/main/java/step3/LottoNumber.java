package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumber() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> shuffle() {
        Collections.shuffle(numbers);
        return numbers;
    }
}
