package lotto.domain;

import java.util.HashMap;
import java.util.Optional;

// TODO: 미완성
public class Result {
    private HashMap<Jackpot, Integer> result;

    public Result() {
        result = new HashMap<>();
        result.put(Jackpot.THREE, 1);
    }

    public int getNumOfCorrected(Jackpot jackpot) {
        return Optional.ofNullable(result.get(jackpot)).orElseGet(() -> 0);
    }
}
