package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static lotto.utils.Validator.checkNotNull;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int TWICE_LOTTO_NUMBERS_SIZE = LOTTO_NUMBERS_SIZE * 2;
    public static final String DUPLICATION_ERROR_MESSAGE = "번호의 중복을 허용하지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers publish(ShuffleStrategy shuffleStrategy) {
        List<LottoNumber> lottoNumbers = LottoNumber.listOf(LOTTO_NUMBERS_SIZE, shuffleStrategy);
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers of(List<Integer> numbers) {
        checkNotNull(numbers);
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        Collections.sort(lottoNumbers);
    }

    private static void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplication(lottoNumbers);
    }

    private static void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또번호는 %s 개 여야합니다.", LOTTO_NUMBERS_SIZE));
        }
    }

    private static void checkDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> notDuplicatedNumbers = new HashSet<>(lottoNumbers);
        if (notDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> lottoNumbers() {
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Grade rank(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        checkWinningNumbers(lastWinningNumbers, bonusNumber);
        Set<LottoNumber> allNumbers = mergeWithLottoNumbers(lastWinningNumbers.lottoNumbers);
        return Grade.from(TWICE_LOTTO_NUMBERS_SIZE - allNumbers.size(), allNumbers.contains(bonusNumber));
    }

    private void checkWinningNumbers(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        checkNotNull(lastWinningNumbers, bonusNumber);
        List<LottoNumber> lottoNumbers = lastWinningNumbers.lottoNumbers;
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private Set<LottoNumber> mergeWithLottoNumbers(List<LottoNumber> winningNumbers) {
        Set<LottoNumber> allNumbers = new HashSet<>();
        allNumbers.addAll(lottoNumbers);
        allNumbers.addAll(winningNumbers);
        return allNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
