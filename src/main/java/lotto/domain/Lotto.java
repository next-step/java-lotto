package lotto.domain;


import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Lotto {
   
    private final SortedSet<LottoNumber> numbers;

    public static final int LOTTO_NUMBER_LIMIT = 6;

    public Lotto(Integer ... numbers) {
        this(toLottoNumbers(numbers));
    }

    public Lotto(List<LottoNumber> numbers){
        this(new TreeSet<>(numbers));
    }

    public Lotto(TreeSet<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBER_LIMIT)
            throw new IllegalArgumentException("로또의 숫자는 6개이여야 합니다. 주어진 숫자는 " + numbers.size());
        this.numbers = numbers;
    }

    private static List<LottoNumber> toLottoNumbers(Integer ... numbers){
        return Arrays.stream(numbers).map(LottoNumber::from).collect(Collectors.toUnmodifiableList());
    }

    public Long countMatchNumbers(Lotto answerSheetNumbers) {
        return answerSheetNumbers.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean containsNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
