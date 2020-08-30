package step4.domain;

import step4.domain.LottoFactory.LottoNo;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int MAX_NUMBER = 6;

    private final List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int findWinningNumbersCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containsLottoNo)
                .count();
    }

    public boolean containsLottoNo(LottoNo lottoNo) {
        return numbers.contains(lottoNo);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
