package lotto.domain;

import lotto.constant.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int FIFTH_MATCHING_COUNT = 3;
    private final Lottoes lottoes;
    private final WinningNumbers winningNumbers;

    public LottoGame(Lottoes lottoes, WinningNumbers winningNumbers) {
        this.lottoes = lottoes;
        this.winningNumbers = winningNumbers;
    }

    public LottoGameResult getResult() {
        List<Rank> collect = lottoes.getValue().stream()
                .map(winningNumbers::getRank)
                .filter(rank -> rank.getMatchingNumberCount() < FIFTH_MATCHING_COUNT)
                .collect(Collectors.toList());

        return new LottoGameResult(collect);
    }
}
