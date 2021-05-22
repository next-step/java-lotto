package lotto;

import java.util.ArrayList;
import java.util.List;

public class SublistStrategy implements AutomaticStrategy {
    public ArrayList<Integer> choose(List<Integer> numbers) {
        return new ArrayList<>(numbers.subList(0, SIZE));
    }
}
