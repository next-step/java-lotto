package views;

import step2.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoFormatter {

    private final Set<LottoNumber> numbers;

    public LottoFormatter(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public String numbersAsListString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(null);
        return lottoNumbers.toString();
    }
}
