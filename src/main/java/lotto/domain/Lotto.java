package lotto.domain;

import java.util.*;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLottoNumberRange(numbers);
        validLottoNumberCount(numbers);
        validDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validLottoNumberRange(List<Integer> numbers) {
        Integer max = Collections.max(numbers);
        Integer min = Collections.min(numbers);
        if (max > MAX_NUM || min < MIN_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45까지만 존재합니다.");
        }
    }

    private void validLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        Set<Integer> deduplicationLotto = new HashSet<>(numbers);
        if (deduplicationLotto.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getRank(Lotto winner) {
        return ConfirmationOfWinning.getRank(winner, this);
    }

    public String getString() {
        return numbers.toString();
    }

}

