package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNo> winningNumbers;
    private final LottoNo bonusBall;

    public WinningNumbers(int[] lottoNos, int bonusBall) {
        this.winningNumbers = Arrays.stream(lottoNos)
                .boxed()
                .map(LottoNo::new)
                .collect(Collectors.toList());
        this.bonusBall = new LottoNo(bonusBall);
    }

    public boolean isWinningNumber(LottoNo lottoNo) {
        return winningNumbers.stream()
                .collect(Collectors.toList())
                .contains(lottoNo);
    }

    public boolean isMatchBonus(LottoNo lottoNo) {
        return bonusBall.equals(lottoNo);
    }

}
