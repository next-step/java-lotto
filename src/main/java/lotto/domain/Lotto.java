package lotto.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1_000;
    private static final int SIZE = 6;
    private static final String STRING_SPLITTER = ", ";

    private Set<LottoNumber> values = new LinkedHashSet<>();

    public Lotto(Set<LottoNumber> values) {
        if (values.isEmpty() || values.size() != SIZE) {
            throw new IllegalArgumentException("유효하지 않은 로또입니다.");
        }
        this.values = values;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        Set<LottoNumber> newLotto = new LinkedHashSet<>();
        for (LottoNumber number : numbers) {
            newLotto.add(number);
        }
        return new Lotto(newLotto);
    }

    public static Lotto from(String stringNumbers) {
        Set<LottoNumber> newLotto = new LinkedHashSet<>();
        String[] numbers = stringNumbers.split(STRING_SPLITTER);
        for (String number : numbers) {
            newLotto.add(LottoNumber.from(Integer.parseInt(number)));
        }
        return new Lotto(newLotto);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) values.stream()
                .filter(number -> otherLotto.contains(number))
                .count();
    }

    public boolean contains(LottoNumber number) {
        return values.contains(number);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
