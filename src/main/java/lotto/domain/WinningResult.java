package lotto.domain;

import lotto.context.Rank;
import lotto.util.LottoUtil;

import java.util.List;
import java.util.Objects;

public class WinningResult {
    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningResult(String lottoNumberText, int bonusBall) {
        validLottoNumberText(lottoNumberText);
        this.winningNumbers = LottoUtil.initTextToLotto(lottoNumberText);
        this.bonusBall = new LottoNumber(bonusBall);
    }
//
    private void validLottoNumberText(String lottoNumberText) {
        if (Objects.isNull(lottoNumberText) || lottoNumberText.isEmpty()) {
            throw new IllegalArgumentException("지난 주 당첨번호 입력 에러");
        }
    }

    public int getCountByRank(List<Lotto> lottoNumbers, Rank rank) {
        return (int) lottoNumbers.stream()
                .map(lotto -> Rank.getRank(winningNumbers.getCountByMatch(lotto),
                        lotto.isBonus(bonusBall)))
                .filter(loopRank -> loopRank.equals(rank))
                .count();
    }
}
