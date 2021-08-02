package edu.nextstep.lotto.step2.vo;

import edu.nextstep.lotto.step2.domain.WinningList;

import java.util.List;

public class LottoNumber {

    private final List<Integer> lottoNumbers;

    public LottoNumber(LottoShuffle lottoShuffle) {
        lottoNumbers = lottoShuffle.shuffle();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchResult(WinningList winningList) {
        return winningList.getWinningNumberList().stream()
                .mapToInt(winningNumber -> lottoNumbers.contains(winningNumber.getNumber()) ? 1 : 0)
                .sum();
    }
}
