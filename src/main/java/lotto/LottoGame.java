package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    private Map<Integer, List<Integer>> result = new HashMap<>();

    public void add(int round, int[] winningNumbers) {
        result.put(round, Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()));
    }

    public List<Integer> get(int round) {
        return result.get(round);
    }
}
