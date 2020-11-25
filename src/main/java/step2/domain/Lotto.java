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
        for (int number = LottoConstant.START_NO; number <= LottoConstant.END_NO; number++) {
            allNumbers.add(number);
        }

        Collections.shuffle(allNumbers);
        this.numbers = allNumbers.subList(LottoConstant.ZERO, LottoConstant.NEED_COUNT);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
