package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 숫자는 6개여야 합니다.";
    public static final String SEPARATOR = ",";

    private Set<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<>(lotto);
        validateLotto();
    }

    public static Lotto of(List<Integer> numbers) {
        return of(numbers.toArray(new Integer[0]));
    }

    public static Lotto of(String value) {
        String[] numbers = value.split(SEPARATOR);
        Integer[] lottoNumbers = Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return of(lottoNumbers);
    }

    public static Lotto of(Integer... numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    private void validateLotto() {
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lotto) {
            sortedNumbers.add(Integer.valueOf(lottoNumber.toString()));
        }
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
