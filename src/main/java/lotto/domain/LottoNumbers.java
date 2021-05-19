package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또번호 목록.
 */
public class LottoNumbers {

    private List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getSize() {
        return this.numbers.size();
    }
}
