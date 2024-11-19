package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int PRICE = 1000;
    public static final int NUMBER_OF_LOTTO_NUMBER = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        this.lottoNumbers = numbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBER)
                .sorted()
                .map(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(TreeSet::new),
                        Collections::unmodifiableSortedSet
                ));
    }

    public LottoNumbers(Set<Integer> numbers) {
        validateCount(numbers);

        this.lottoNumbers = toLottoNumberSet(numbers);
    }

    public LottoNumbers(String input) {
        validateEmptyInput(input);

        Set<Integer> numbers = toIntegerSet(input);
        validateCount(numbers);

        this.lottoNumbers = toLottoNumberSet(numbers);
    }

    private void validateCount(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("중복되지 않은 " + NUMBER_OF_LOTTO_NUMBER + "개의 로또번호가 필요합니다.");
        }
    }

    private Set<LottoNumber> toLottoNumberSet(Set<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(TreeSet::new),
                        Collections::unmodifiableSortedSet
                ));
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨번호를 입력해 주세요.");
        }
    }

    private Set<Integer> toIntegerSet(String input) {
        try {
            String[] split = input.split(",");

            return Arrays.stream(split)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public int countIdenticalLottoNumberSet(LottoNumbers that) {
        Set<LottoNumber> compare = new HashSet<>();
        compare.addAll(this.lottoNumbers);
        compare.addAll(that.lottoNumbers);

        int difference = compare.size() - this.lottoNumbers.size();

        return this.lottoNumbers.size() - difference;
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        String[] numbers = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .toArray(String[]::new);

        return "[" + String.join(", ", numbers) + "]";
    }
}

