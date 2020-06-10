package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumbers() {
        for (int i = 1 ; i <= 45 ; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
