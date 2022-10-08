package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = getLottoNumbers();
    }

    private List<Integer> makeNumberArray() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = makeNumberArray();
        Collections.shuffle(numbers);
        List<Integer> sixNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            sixNumbers.add(numbers.get(i));
        }
        return sixNumbers;
    }

}
