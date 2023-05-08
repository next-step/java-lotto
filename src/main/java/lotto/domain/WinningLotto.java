package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    public WinningLotto(List<Integer> inNumbers) {
        super(inNumbers);
    }

    public int countMatchingWith(Lotto inLotto) {
        int count = 0;
        for (Integer number: numbers) {
            count += boolToInt(inLotto.contains(number));
        }
        return count;
    }

    private int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }
}
