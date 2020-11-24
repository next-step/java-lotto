package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberMaker {
    private static List<Integer> wholeNumbers;

    public LottoNumberMaker() {
        wholeNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            wholeNumbers.add(i);
        }
    }

    public List<Integer> makeNumber() {
        List<Integer> shuffleNumbers = wholeNumbers;
        Collections.shuffle(shuffleNumbers);
        List<Integer> pickNumbers = shuffleNumbers.subList(0, 6);
        Collections.sort(pickNumbers);
        return pickNumbers;
    }

}
