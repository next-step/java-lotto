package lotto_second.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

}
