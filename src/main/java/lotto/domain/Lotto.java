package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(String[] numbers) {
        this(StringToList(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    private static List<LottoNumber> StringToList(String[] numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(new LottoNumber(Integer.parseInt(numbers[i])));
        }
        return list;
    }

    public int matchedCount(Lotto lotto) {
        int cnt = 0;

        for (int i = 0; i < lotto.value().size(); i++) {
            cnt += containsNumber(lotto.value().get(i));
        }
        return cnt;
    }

    private int containsNumber(LottoNumber number) {
        return this.numbers.contains(number) ? 1 : 0;
    }

    public List<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
