package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private LottoNumbers winningNumbers;
    private final Map<Integer, Integer> winningRewards = new HashMap<>();

    public LottoGame(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int howManyMatched(LottoNumbers userNumbers) {
        return winningNumbers.howManyMatched(userNumbers);
    }
}
