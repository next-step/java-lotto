package step2.domain;

import java.util.*;

public class Lotto {

    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);

    private Map<Integer, Boolean> lottoNumbers = new HashMap<>();

    public Lotto() {
        Collections.shuffle(numbers);
        for (int i = 0; i < 6; i++) {
            lottoNumbers.put(numbers.get(i), true);
        }
    }

    public Lotto(Integer[] input) {
        for (int i = 0; i < 6; i++) {
            lottoNumbers.put(input[i], true);
        }
    }

    public int matchCount(Lotto lotto) {
        int count = 0;
        Map<Integer, Boolean> map = lotto.getLottoNumbers();

        for (Integer key : map.keySet()) {
            count += isContainKey(key);
        }
        return count;
    }

    private int isContainKey(Integer key) {
        if (lottoNumbers.containsKey(key)) {
            return 1;
        }
        return 0;
    }


    public Map<Integer, Boolean> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers.keySet() + "";
    }
}
