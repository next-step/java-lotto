package lotto.domain;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Lotto {

    public LottoNumbers generateLotto() {
        return new LottoNumbers(generateRandoms());
    }

    public List<Integer> generateRandoms() {
        List<Integer> numberCards = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberCards.add(i);
        }
        Collections.shuffle(numberCards);
        List<Integer> picked = numberCards.subList(0, 5);
        Collections.sort(picked);
        return picked;
    }
}
