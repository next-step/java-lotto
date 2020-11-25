package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        createLottoNumber();
    }

    private void createLottoNumber() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++) {
            allNumbers.add(number);
        }

        Collections.shuffle(allNumbers);
        this.numbers = allNumbers.subList(0, 6);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
