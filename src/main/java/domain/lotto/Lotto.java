package domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;
    private final static int LOTTO_NUMBER_SIZE = 6;

    public static Lotto from(List<Integer> numbers) {
        verifyExistsNumbers(numbers);
        verifyOutNumber(numbers);
        verifyDuplicateNumber(numbers);
        return new Lotto(Collections.unmodifiableList(toLottoNumber(numbers)));
    }

    private static void verifyOutNumber(List<Integer> numbers) {
        if (outNumber(numbers)) {
            throw new IllegalArgumentException("로또 숫자 갯수 " + LOTTO_NUMBER_SIZE + "개 보다 많이 입력됐습니다.");
        }
    }

    private static boolean outNumber(List<Integer> numbers) {
        return numbers.size() > LOTTO_NUMBER_SIZE;
    }

    private static void verifyExistsNumbers(List<Integer> numbers) {
        if (nullableNumber(numbers)) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다.");
        }
    }

    private static boolean nullableNumber(List<Integer> numbers) {
        return numbers == null;
    }

    private static void verifyDuplicateNumber(List<Integer> numbers) {
        if (nullableNumber(numbers)) {
            throw new IllegalArgumentException("비어있는 숫자는 로또를 생성할 수 없습니다.");
        }

        Set<Integer> numberList = new HashSet<>(numbers);
        if (numberList.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private static List<LottoNumber> toLottoNumber(List<Integer> intNumbers) {
        return intNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countOfMatch(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(number -> otherLotto.contain(number))
                .count();
    }
}
