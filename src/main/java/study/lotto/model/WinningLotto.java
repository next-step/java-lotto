package study.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto of(String[] winningNumbers) {
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers)
                                                .map(Integer::parseInt)
                                                .map(LottoNumber::of)
                                                .collect(Collectors.toList());

        return new WinningLotto(Lotto.of(winningNumberList));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }

    public LottoRank checkLottoRank(Lotto lotto, int bonusNumber) {
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
