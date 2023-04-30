package lotto.domain;

import lotto.util.LottoValidationUtils;

import java.util.LinkedHashSet;
import java.util.List;

public class Numbers {

    private LinkedHashSet<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new LinkedHashSet<>(numbers);
        LottoValidationUtils.validateLottoNumbers(this.numbers);
    }

    public LinkedHashSet<Integer>  getLottoNumbers() {
        return numbers;
    }

}
