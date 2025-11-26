package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(createNumbers(intToList(numbers)));
    }

    public Lotto(String... numbers) {
        this(createNumbers(stringToList(numbers)));
    }

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(createNumbers(numbers));
    }

    private static List<LottoNumber> createNumbers(List<Integer> numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (Integer number : numbers) {
            list.add(new LottoNumber(number));
        }
        return list;
    }

    private static List<Integer> stringToList(String... numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    private static List<Integer> intToList(int... numbers) {
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        return list;
    }

    public int matchedCount(Lotto lotto) {
        return lotto.matchedCount(this.numbers);
    }

    public int matchedCount(List<LottoNumber> lottoNumbers) {
        int cnt = 0;

        for (LottoNumber lottoNumber: lottoNumbers) {
            cnt += containsNumber(lottoNumber);
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
