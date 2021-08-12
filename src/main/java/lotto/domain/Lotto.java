package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int SIZE = 6;
    private static final String INVALID_SIZE_OF_WINNING_NUMBERS = "번호의 갯수가 올바르지 않습니다.";

    private Set<LottoNumber> numbers;

    public Lotto(LottoRandomNumbers allNumbers) {
        numbers = new TreeSet<>();
        while (numbers.size() < SIZE) {
            numbers.add(new LottoNumber(allNumbers.generateRandomNumbers()));
        }
    }

    public Lotto(String strNumbers) {
        numbers = new TreeSet<>();
        for (String strNumber : strNumbers.split(",")) {
            numbers.add(new LottoNumber(Integer.parseInt(strNumber)));
        }
        validateLottoSize();
    }

    private void validateLottoSize() {
        if (numbers.size() != SIZE) {
            throw new InvalidInputException(INVALID_SIZE_OF_WINNING_NUMBERS);
        }
    }

    public int getMatchCount(Lotto winningLotto) {
        return (int) winningLotto.getLottoNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return numbers;
    }


}
