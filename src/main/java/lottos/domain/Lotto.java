package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.*;

public class Lotto {

    private List<Integer> elements;

    public Lotto() {
        this.elements = getRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeIncorrectException();
        }
        this.elements = numbers;
    }

    private List<Integer> getRandomNumbers() {
        Set<Integer> randoms = new HashSet<>();
        while (randoms.size() != 6) {
            int number = (int) (Math.random() * 45) + 1;
            randoms.add(number);
        }
        return new ArrayList<>(randoms);
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public int match(Lotto lotto) {
        int countOfMatches = 0;
        for (int number : lotto.getElements()) {
            if (elements.contains(number)) {
                countOfMatches++;
            }
        }
        return countOfMatches;
    }
}
