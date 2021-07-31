package lottos.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> elements;

    public Lotto() {
        this.elements = getRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.elements = numbers;
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int number = (int) (Math.random() * 45) + 1;
            randoms.add(number);
        }
        return randoms;
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public int match(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getElements()) {
            if (elements.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
