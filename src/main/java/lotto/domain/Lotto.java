package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkNumberCount(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    private void checkNumberCount(List<LottoNumber> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctCount != COUNT) {
            throw new IllegalArgumentException("로또 숫자는 " + COUNT +"개 선택되어야 합니다.");
        }
    }

    public Prize matches(Lotto winNumbers, LottoNumber bonusNumber) {
        int matchNumber = matchNumberCount(winNumbers);
        boolean hasBonusNumber = hasNumber(bonusNumber);
        return Prize.toPrize(matchNumber, hasBonusNumber);
    }

    private int matchNumberCount(Lotto winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers.numbers::contains)
                .count();
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
