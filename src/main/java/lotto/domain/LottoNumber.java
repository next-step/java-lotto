package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    List<Integer> allNumbers;

    public LottoNumber() {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) allNumbers.add(i);
    }

    public List<Integer> getLottoNumber() {
        Collections.shuffle(allNumbers);
        return allNumbers.subList(0, 5);
    }

}
