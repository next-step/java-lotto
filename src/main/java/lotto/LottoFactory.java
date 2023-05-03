package lotto;

import java.util.*;

public class LottoFactory {

    public static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            NUMBERS.add(i);
        }
    }

    public static Map<Integer, List<Integer>> generateLottoNumbers(int count) {
        Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(NUMBERS);
            List<Integer> selectedNumbers = new ArrayList<>(NUMBERS.subList(0, 6));
            lottoNumbers.put(i, selectedNumbers);
        }
        return lottoNumbers;
    }
}
