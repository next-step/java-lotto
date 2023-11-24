package step4.model;

import step4.enumeration.LottoRank;

import java.util.List;

import static step4.enumeration.LottoRank.SECOND;

public class LottoNumbers {

    private static final int MAX_LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public LottoRank getLottoRank(List<Integer> winNumbers, int bonusNumber) {
        int count = (int) winNumbers.stream()
                .filter(this::isContain)
                .count();

        if (LottoRank.isSecondRank(count, bonusNumber, this.numbers)) {
            return SECOND;
        }

        return LottoRank.getRank(count);
    }

    public boolean isContain(int number) {
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("로또 번호가 없습니다.");
        }

        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개가 되어야 합니다.");
        }
    }
}
