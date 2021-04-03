package lotto.domain;

import lotto.utils.ConvertUtil;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final int BOUND_MAX = 45;
    private static final int BOUND_MIN = 1;
    private static final String CHECK_LENGTH = String.format("당첨 번호의 길이는 %d(이)여야 합니다.", NUMBER_LENGTH);
    private static final String CHECK_BOUND = String.format("당첨 번호는 %d ~ %d 범위의 값이어야 합니다.", BOUND_MIN, BOUND_MAX);
    private static final String CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public static WinningNumbers from(List<String> winningNumbers) {
        return new WinningNumbers(ConvertUtil.toIntegers(winningNumbers)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public static WinningNumbers from(int... winningNumbers) {
        return new WinningNumbers(Arrays.stream(winningNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public MatchedCount matchedCountWith(List<LottoNumber> lottoNumbers) {
        return new MatchedCount(winningNumbers, lottoNumbers);
    }

    public void check(LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CHECK_DUPLICATION);
        }
    }

    private void validate(List<LottoNumber> winningNumbers) {
        checkLength(winningNumbers);
        checkBound(winningNumbers);
        checkDuplication(winningNumbers);
    }

    private void checkLength(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_LENGTH);
        }
    }

    private void checkBound(List<LottoNumber> winningNumbers) {
        for (LottoNumber winningNumber : winningNumbers) {
            checkBound(winningNumber.lottoNumber());
        }
    }

    private void checkBound(Integer number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
    }

    private void checkDuplication(List<LottoNumber> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_DUPLICATION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
