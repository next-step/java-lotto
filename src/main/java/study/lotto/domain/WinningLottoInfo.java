package study.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoInfo {
    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLottoInfo(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoInfo of(String[] winningNumbers, int bonusNumber) {
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers)
                                                .map(Integer::parseInt)
                                                .map(LottoNumber::of)
                                                .collect(Collectors.toList());

        return new WinningLottoInfo(Lotto.of(winningNumberList), bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if(winningLotto.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException("당첨 번호에 보너스볼 번호가 포함되면 안됩니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }

    public LottoRank checkLottoRank(Lotto lotto) {
        return LottoRank.find(
                (int)compareToWinningNumbers(lotto),
                containsBonusNumber(lotto, bonusNumber));
    }

    public long compareToWinningNumbers(Lotto lotto) {
        return winningLotto.getLottoNumbers()
                .stream()
                .filter(lotto::contains)
                .count();
    }

    private boolean containsBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(LottoNumber.of(bonusNumber));
    }
}
