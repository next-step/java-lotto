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

    public Division compareLotto(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(number -> lotto.numbers.contains(number))
                .count();
        return Division.valueOf((int)matchCount);
    }

    public Division compareLotto(Lotto lotto, int bonusNumber) {
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        long matchCount = numbers.stream()
                .filter(number -> lotto.numbers.contains(number))
                .count();
        boolean matchBonus = numbers.contains(bonusLottoNumber);
        return Division.valueOf((int)matchCount, matchBonus);
    }

    public Division compareLotto(WinningLotto winningLotto) {
        int matchCount = (int)checkMatchCount(winningLotto);
        boolean matchBonus = winningLotto.matchBonusNumber(numbers);
        return Division.valueOf(matchCount, matchBonus);
    }

    private long checkMatchCount(WinningLotto winningLotto) {
        return numbers.stream()
                .filter(number -> winningLotto.contains(number))
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
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
