package lotto.domain;

import lotto.constant.Lotto;
import lotto.constant.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final Lottoes lottoes;
    private final WinningNumbers winningNumbers;

    public LottoGame(Lottoes lottoes, WinningNumbers winningNumbers) {
        this.lottoes = lottoes;
        this.winningNumbers = winningNumbers;
    }

    public LottoGameResult getResult() {
        List<Rank> collect = lottoes.getValue().stream()
                .map(winningNumbers::getRank)
                .collect(Collectors.toList());

        int purchaseAmount = lottoes.getValue().size() * Lotto.PRICE;

        return new LottoGameResult(collect, new PurchaseAmount(purchaseAmount));
    }
}
