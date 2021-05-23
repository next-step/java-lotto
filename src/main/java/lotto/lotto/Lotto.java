package lotto.lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers = new HashSet<>();

    public void addNumber(LottoNumber lottoNumber) {
        if (!isContain(lottoNumber)) {
            numbers.add(lottoNumber);
        }
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    private boolean isContain(LottoNumber number) {
        return numbers.stream().anyMatch(item -> item.equals(number));
    }
}
