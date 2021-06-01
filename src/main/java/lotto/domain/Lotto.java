package lotto.domain;

import java.util.*;

public class Lotto {

    static List<Integer> LOTTO_NUMBER_POOL = Arrays.asList(
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45
    );
    static int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateLotto();
        Collections.sort(this.numbers);
    }

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        List<Integer> numbers = LOTTO_NUMBER_POOL.subList(0, LOTTO_SIZE);
        this.numbers = new ArrayList<>(numbers);
        validateLotto();
        Collections.sort(numbers);
    }


    private void validateLotto() {
        validateNumbers();
        validateDuplicate();
    }

    private void validateDuplicate() {
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_SIZE + "개를 선택할 수 있습니다.");
        }
    }

    private void validateNumbers() {
        if (!LOTTO_NUMBER_POOL.containsAll(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자로 구성되어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
