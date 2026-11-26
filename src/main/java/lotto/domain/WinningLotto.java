package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int matchCount(Lotto lotto) {
        List<Integer> matched = new ArrayList<>(getNumbers());
        matched.retainAll(lotto.getNumbers());
        return matched.size();
    }
}
