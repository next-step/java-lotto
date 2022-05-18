package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_COUNT = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
       this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validLottoNumberCount(this.numbers);
    }


    private void validLottoNumberCount(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }


    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public int getRank(Lotto winner) {
        return ConfirmationOfWinning.getRank(winner, this);
    }

    public String getLottoNumberString() {
        return numbers.toString();
    }

}

