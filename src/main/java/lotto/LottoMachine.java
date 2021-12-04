package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoMachine {
    private static final List<Integer> MATCHING_COUNTS = Arrays.asList(3, 4, 5, 6);
    private final Lottos lottos;

    public LottoMachine(int quantity) {
        this(new Lottos(quantity));
    }

    public LottoMachine(Lottos lottos) {
        this.lottos = lottos;
    }

    public HashMap<Integer, Long> result(LottoNumbers winningNumbers) {
        HashMap<Integer, Long> result = new HashMap<>();

        for (Integer matchingCount : MATCHING_COUNTS) {
            long matchedLottoNumbersCount = lottos.result(winningNumbers, count -> count == matchingCount);
            result.put(matchingCount, matchedLottoNumbersCount);
        }

        return result;
    }

    public Lottos lottos() {
        return this.lottos;
    }
}
