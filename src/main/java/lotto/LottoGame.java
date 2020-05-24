package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoGame {

    private Map<Integer, Lotto> result = new HashMap<>();

    public Lotto add(int round, int[] winningNumber) {

        List<Integer> convertedList = Arrays.stream(winningNumber).boxed()
                .collect(Collectors.toList());

        return result.put(round, new Lotto(convertedList));
    }
}
