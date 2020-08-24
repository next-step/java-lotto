package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNo> winningNumbers;

    public WinningNumbers(int[] lottoNos, int bonusBall) {
        this.winningNumbers = Arrays.stream(lottoNos)
                .boxed()
                .map(LottoNo::new)
                .collect(Collectors.toList());
        this.winningNumbers.add(new LottoNo(bonusBall, true));
    }

    public boolean isWinningNumber(LottoNo lottoNo) {
        return winningNumbers.stream()
                .filter(LottoNo::isWinningNumber)
                .collect(Collectors.toList())
                .contains(lottoNo);
    }

    public boolean isMatchBonus(LottoNo lottoNo) {
        return winningNumbers.stream()
                .filter(LottoNo::isMatchBonus)
                .collect(Collectors.toList())
                .contains(lottoNo);
    }

}
