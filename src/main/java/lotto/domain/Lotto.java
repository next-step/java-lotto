package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final int DIGIT = 6;
    private final String SEPARATOR = ",";

    private final List<LottoNumber> numbers = new ArrayList<>();

    public Lotto(List<Integer> values) {
        validateCount(values);
        values.forEach(value -> {
            this.numbers.add(new LottoNumber(value));
        });
        Collections.sort(this.numbers);
    }

    private void validateCount(final List<Integer> values) {
        if (values.size() != DIGIT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

    public Lotto(final String value) {
        String[] splited = value.split(SEPARATOR);
        validateCount(splited);
        for (String token : splited) {
            this.numbers.add(LottoNumber.from(token));
        }
        Collections.sort(this.numbers);
    }

    private void validateCount(final String[] splited) {
        if (splited.length != DIGIT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

    public WinningInformation matchWithWinningLotto(final Lotto lotto) {
        int countOfSameNumber = (int) lotto.numbers.stream()
            .filter(this.numbers::contains)
            .count();

        return WinningInformation.findByCountOfMatchedNumber(countOfSameNumber);
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
