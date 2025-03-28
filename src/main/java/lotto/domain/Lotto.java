package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    public static final int LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    private Lotto() {
        List<Integer> lottoNumberCandidate = new ArrayList<>();
        for (int i = 1; i <= LOTTO_NUMBER_UPPER_BOUND; ++i) {
            lottoNumberCandidate.add(i);
        }
        Collections.shuffle(lottoNumberCandidate);
        this.numbers = sortNumbers(cropNumbers(lottoNumberCandidate));
    }

    private Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto createQuickPick() {
        return new Lotto();
    }

    public static Lotto createManually(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateDuplicates(numbers);
        validateNumber(numbers);
    }

    private void validateNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> isLottoOutOfRange(number))
                .findAny()
                .ifPresent(invalid -> {
                    throw new IllegalArgumentException("로또 번호의 범위는 1부터 " + LOTTO_NUMBER_UPPER_BOUND + "까지 입니다.");
                });
    }

    private static void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호의 개수는 " + LOTTO_COUNT + "개이어야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        List<Integer> noDuplicateNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (noDuplicateNumbers.size() < LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isLottoOutOfRange(Integer number) {
        return number < 1 || number > LOTTO_NUMBER_UPPER_BOUND;
    }

    private List<Integer> cropNumbers(List<Integer> numbers) {
        return numbers.subList(0, LOTTO_COUNT);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public Division compareNumbers(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(number -> lotto.numbers.contains(number))
                .count();
        return Division.valueOf((int)matchCount);
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
