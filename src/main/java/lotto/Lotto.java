package lotto;

import java.util.*;

public class Lotto {
    private int count = 0;
    private final List<Integer> numbers = new ArrayList<>();
    private final Map<Integer, List<Integer>> lottoNumbers = new HashMap<>();

    public Lotto(int count) {
        init(count);
    }

    public Map<Integer, List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }


    private void init(int count) {
        this.count = count;
        for (int i = 1; i <= 45; i++) {
            this.numbers.add(i);
        }
        generateLottoNumbers();
    }

    private void generateLottoNumbers() {
        for (int i = 0; i < count; i++) {
            Collections.shuffle(numbers);
            List<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, 6));
            lottoNumbers.put(i, selectedNumbers);
        }
    }
}
