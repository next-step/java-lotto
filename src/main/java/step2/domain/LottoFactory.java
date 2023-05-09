package step2.domain;

import java.util.List;

public class LottoFactory {

    public static List<List<Integer>> generateLotto(LottoGenerateStrategy strategy) {
        return strategy.generate();
    }
}
