package step2.domain.impl;

import step2.domain.ChangeMoney;
import step2.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoProvider {

    private static final List<String> baseNumber = initBaseNumber();
    private static final int START = 1;
    private static final int END = 45;

    private static List<String> initBaseNumber() {
        List<String> result = new ArrayList<>();
        for (int i = START; i <= END; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    public List<Lotto> generate(ChangeMoney changeMoney) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < changeMoney.getRemainCount().getValue(); i++) {
            String numbers = getRandomNumbers();
            result.add(new Lotto(numbers));
        }
        return result;
    }

    private String getRandomNumbers() {
        Collections.shuffle(baseNumber);
        return String.join(", ", baseNumber.subList(0, Lotto.COUNT));
    }
}
