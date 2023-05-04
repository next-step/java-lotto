package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNumbers {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private ArrayList<Integer> numbers;

    public LottoNumbers(ArrayList<Integer> numbers) {
        validateNumber(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(ArrayList<Integer> numbers) {
        if (numbers.size() < 1 || numbers.size() > 6) {
            throw new IllegalArgumentException("숫자의 입력값은 6개 여야 합니다.");
        }
    }

    private void validateNumber(ArrayList<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException("1~45 이외의 숫자가 포함되어 있습니다.");
        }
    }

    public static LottoNumbers createRandomLottoNumbers() {
        ArrayList<Integer> fullLotteNumbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            fullLotteNumbers.add(i);
        }

        Collections.shuffle(fullLotteNumbers);

        return new LottoNumbers((ArrayList) fullLotteNumbers.subList(0, 6));
    }
}

