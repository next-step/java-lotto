package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_LIMIT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validLottoSize(numbers);
        validDuplicatedLottoNumber(numbers);
        numbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        this.numbers = numbers;
    }

    private void validLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("로또 하나 당 6개의 숫자를 가져야합니다.");
        }
    }

    private void validDuplicatedLottoNumber(List<LottoNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
