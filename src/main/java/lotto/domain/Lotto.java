package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.common.Constants.*;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto() {
        List<LottoNumber> lottoNumberCandidate = new ArrayList<>();
        for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; ++i) {
            lottoNumberCandidate.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberCandidate);
        this.numbers = sortNumbers(cropNumbers(lottoNumberCandidate));
    }

    private Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(number -> new LottoNumber(number))
                .sorted()
                .collect(Collectors.toList());
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

    private List<LottoNumber> cropNumbers(List<LottoNumber> numbers) {
        return numbers.subList(0, LOTTO_COUNT);
    }

    private List<LottoNumber> sortNumbers(List<LottoNumber> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public Division compareNumbers(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(number -> lotto.numbers.contains(number))
                .count();
        return Division.valueOf((int)matchCount);
    }

    public Division compareNumbers(Lotto lotto, int bonusNumber) {
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        validateBonusLottoNumber(bonusLottoNumber);
        long matchCount = numbers.stream()
                .filter(number -> lotto.numbers.contains(number))
                .count();
        boolean matchBonus = numbers.contains(bonusLottoNumber);
        return Division.valueOf((int)matchCount, matchBonus);
    }

    private void validateBonusLottoNumber(LottoNumber bonusLottoNumber) {
        if (numbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 기존 로또 번호와 겹칩니다.");
        }
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
        return numbers.stream()
                .map(number -> number.getValue())
                .collect(Collectors.toList());
    }
}
