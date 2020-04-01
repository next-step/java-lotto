package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static Set<List<Integer>> lottoNumbers;

    public Lotto(int count) {
        lottoNumbers = new HashSet<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers.add(NumberGenerator.generateOneSet());
        }
    }

    public int size() {
        return lottoNumbers.size();
    }
}
