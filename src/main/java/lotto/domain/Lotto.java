package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = setToSortedList(lottoNumbers);
    }

    private List<LottoNumber> setToSortedList(Set<LottoNumber> lottoNumbers) {
        return new ArrayList<>(lottoNumbers).stream()
                .sorted().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
