package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
    }
}
