package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_SIZE_OF_WINNING_NUMBERS = "번호의 갯수가 올바르지 않습니다.";
    public static final int SIZE = 6;

    private Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(String strNumbers) {
        String[] strLottoNumbers = strNumbers.split(",");
        Set<LottoNumber> lottoNumberSet = Arrays.stream(strLottoNumbers)
                                                .map(number -> LottoNumber.valueOf(number))
                                                .collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumberSet);
    }

    private void validateLottoSize(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new InvalidInputException(INVALID_SIZE_OF_WINNING_NUMBERS);
        }
    }

    public int getMatchCount(Lotto winningLotto) {
        return (int) winningLotto.getLottoNumbers()
                                 .stream()
                                 .filter(numbers::contains)
                                 .count();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return numbers;
    }


}
