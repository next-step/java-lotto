package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(LottoRules lottoRules) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lottoNum = lottoRules.getLottoNums();
        Collections.shuffle(lottoNum);
        for (int i = 0; i < lottoRules.getLottoCount(); i++) {
            numbers.add(lottoNum.get(i));
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
