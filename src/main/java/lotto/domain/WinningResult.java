package lotto.domain;

import lotto.context.Rank;
import lotto.util.LottoUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningResult {
    private static final String SPLIT_REGEX = ",";

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningResult(String lottoNumberText, int bonusBall) {
        validLottoNumberText(lottoNumberText);
        this.winningNumbers = initWinningLotto(lottoNumberText);
        this.bonusBall = new LottoNumber(bonusBall);
    }
//
    private void validLottoNumberText(String lottoNumberText) {
        if (Objects.isNull(lottoNumberText) || lottoNumberText.isEmpty()) {
            throw new IllegalArgumentException("지난 주 당첨번호 입력 에러");
        }
    }

    private Lotto initWinningLotto(String lottoNumberText) {
        List<Integer> numberList = Arrays.stream(lottoNumberText.split(SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return LottoUtil.createMenualLotto(numberList);
    }

    public int getCountByRank(List<Lotto> lottoNumbers, Rank rank) {
        return (int) lottoNumbers.stream()
                .map(lotto -> Rank.getRank(winningNumbers.getCountByMatch(lotto),
                        lotto.isBonus(bonusBall)))
                .filter(loopRank -> loopRank.equals(rank))
                .count();
    }
}
