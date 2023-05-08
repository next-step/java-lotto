package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    public WinningLotto(List<Integer> inNumbers) {
        super(inNumbers);
    }

    public int countMatchingWith(Lotto inLotto) {
        return (int) numbers.stream()
                .filter(inLotto::contains)
                .count();
    }
}
