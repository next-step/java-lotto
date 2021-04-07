package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.utils.ConvertUtil.toIntOrThrow;

public class WinningNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final String CHECK_LENGTH = String.format("당첨 번호의 길이는 %d(이)여야 합니다.", NUMBER_LENGTH);
    private static final String CHECK_WINNING_NUMBER = "입력하신 당첨 번호 %s가 숫자인지 확인해주세요.";
    private static final String CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public static WinningNumbers from(List<String> winningNumbers) {
        return new WinningNumbers(winningNumbers
                .stream()
                .map(WinningNumbers::toInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static WinningNumbers from(int... winningNumbers) {
        return new WinningNumbers(Arrays.stream(winningNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private static Integer toInt(String winningNumber) {
        return toIntOrThrow(winningNumber,
                () -> new IllegalArgumentException(
                        String.format(CHECK_WINNING_NUMBER, winningNumber)
                ));
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
        checkDuplication(winningNumbers);
    }

    private void checkLength(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_LENGTH);
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
