package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.RandomLottoNumberGenerator;

public class Lotto {

    private final int PLACE = 6;
    private final String SEPARATOR = ",";

    private final List<LottoNumber> numbers = new ArrayList<>();

    public Lotto() {
        for (int i = 0; i < PLACE; i++) {
            this.numbers.add(RandomLottoNumberGenerator.generate());
        }
        Collections.sort(this.numbers);
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
        if (splited.length != PLACE) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

    public int countSameNumbers(final Lotto lotto) {
        return (int) lotto.numbers.stream()
            .filter(this.numbers::contains)
            .count();
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }
}
