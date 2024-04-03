package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private final Integer[] lotto;

    public Lotto(Integer[] numbers) {
        this.validateNumbers(numbers);

        this.lotto = numbers;
    }

    public Lotto() {
        this(generateLottoNumbers());
    }

    public Integer[] getLotto() {
        return lotto;
    }

    private void validateNumbers(Integer[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또 번호의 길이는 여섯 자리입니다.");
        }

        boolean isInRange = Arrays.stream(numbers).allMatch(number -> number >= LOWER_BOUND && number <= UPPER_BOUND);

        if (!isInRange) {
            throw new IllegalArgumentException("로또 번호의 범위는 1부터 45까지 입니다.");
        }
    }

    private static Integer[] generateLottoNumbers() {
        List<Integer> numList = new ArrayList<>();

        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) numList.add(i);
        Collections.shuffle(numList);

        return numList.subList(0, 6).toArray(new Integer[6]);
    }
}
