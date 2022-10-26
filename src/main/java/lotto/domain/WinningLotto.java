package lotto.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusWinningNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusWinningNumber) {
        this.winningLotto = winningLotto;
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public static WinningLotto from(String winningLottoNumbers, String bonusWinningNumber) {
        String winningNumbersNoSpace = removeSpace(winningLottoNumbers);
        Set<Integer> result = Arrays.stream(splitStringToLottoNumbers(winningNumbersNoSpace))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        Lotto resultLotto = new Lotto(result);
        Integer resultBonus = Integer.parseInt(bonusWinningNumber);
        return new WinningLotto(resultLotto, resultBonus);
    }

    private static String[] splitStringToLottoNumbers(String winningNumbersNoSpace) {
        return winningNumbersNoSpace.split(",");
    }

    private static String removeSpace(String winningLottoNumbers) {
        return winningLottoNumbers.replace(" ", "");
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusWinningNumber() {
        return bonusWinningNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusWinningNumber, that.bonusWinningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusWinningNumber);
    }
}
