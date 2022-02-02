package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
