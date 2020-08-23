package domain;

import study.ValidateUtil;
import util.SplitUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningNumbers, int bonusNumber) {
        List<LottoNumber> numbers = getNumbers(winningNumbers, bonusNumber);
        return new WinningLotto(numbers, LottoNumber.valueOf(bonusNumber));
    }

    private static List<LottoNumber> getNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> numbers = SplitUtil.splitToNumber(winningNumbers);
        ValidateUtil.validateLottoWinningNumber(numbers, bonusNumber);

        return numbers.stream()
                .sorted()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public Rank getRank(Lotto lotto) {
        Integer winningCount = winningNumbers.stream()
                .filter(lotto::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.valueOf(winningCount, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
