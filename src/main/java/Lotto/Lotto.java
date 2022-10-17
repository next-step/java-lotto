package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LENGTH = 6;

    private final List<LottoNumber> numbers;
    private static final List<LottoNumber> candidateNumbers;

    static {
        candidateNumbers = new ArrayList<>();
        for (int i = LottoNumber.MAX_NUMBER; i <= LottoNumber.MAX_NUMBER; i ++) {
            candidateNumbers.add(new LottoNumber(i));
        }
    }

    Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;

    }

    Lotto() {
        this.numbers = randomNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

    private List<LottoNumber> randomNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        List<LottoNumber> dupCandidateNumbers = candidateNumbers;

        for (int i = 0; i < LENGTH; i ++) {
            int randomIndex = (int) Math.random() * dupCandidateNumbers.size() + 1;
            numbers.add(dupCandidateNumbers.get(randomIndex));
            dupCandidateNumbers.remove(randomIndex);
        }

        return numbers;
    }
}
