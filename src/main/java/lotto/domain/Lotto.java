package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LIMIT_LOTTO_LENGTH = 7;
    private List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() >= LIMIT_LOTTO_LENGTH) {
            throw new IllegalArgumentException("6자리 초과의 로또 번호가 입력되었습니다.");
        }
        if (numbers.stream().distinct().count() < numbers.size()
        ) {
            throw new IllegalArgumentException("중복되는 로또 번호가 입력되었습니다.");
        }
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public long countHits(Lotto others) {
        return others.getNumbers().stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    public boolean matchBonus(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
