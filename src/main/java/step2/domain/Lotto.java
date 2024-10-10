package step2.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers numbers;

    public Lotto(LottoStrategy strategy) {
        this.numbers = strategy.generateLottoNumbers();
    }


    public int countMatchingNumbers(Lotto other) {
        return (int) this.getNumbers().stream()
                .filter(number -> other.getNumbers().contains(number))
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return numbers.getLottoNumbers();
    }


}
