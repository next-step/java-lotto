package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winner {

    private static final String DELIIMITER = ", ";
    private static final int WINNER_COUNT = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public Winner(String input, String bonus) {
        this.winningNumbers = initWinningNumbers(input);
        this.bonusNumber = initBonusNumber(bonus);
        validateBonusNumberDuplicate();
    }

    private List<LottoNumber> initWinningNumbers(String input) {
        validateNullAndEmpty(input);
        String[] splits = input.split(DELIIMITER);
        validateLength(splits);
        validateDuplicate(splits);
        return Arrays.stream(splits)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private LottoNumber initBonusNumber(String bonus) {
        validateNullAndEmpty(bonus);
        return LottoNumber.from(bonus);
    }

    private void validateNullAndEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 Null 이거나 공백으로 이루어져있습니다.");
        }
    }

    private void validateLength(String[] splits) {
        if (splits.length != WINNER_COUNT) {
            throw new IllegalArgumentException("입력된 지난 당첨회차 번호가 " + WINNER_COUNT + " 가 아닙니다.");
        }
    }

    private void validateDuplicate(String[] splits) {
        long distinctCount = Arrays.stream(splits).distinct().count();
        if (distinctCount != splits.length) {
            throw new IllegalArgumentException("입력 값에 중복된 번호가 있습니다.");
        }
    }

    private void validateBonusNumberDuplicate() {
        if (this.winningNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복될 수 없습니다.");
        }
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return this.winningNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(winningNumbers, winner.winningNumbers) && Objects.equals(bonusNumber, winner.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
