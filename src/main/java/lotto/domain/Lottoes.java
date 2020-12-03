package lotto.domain;

import lotto.view.LottoGameView;

import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {

    private final List<LottoNumbers> value;
    private final PurchaseAmount purchaseAmount;

    public Lottoes(int lottoAmount) {
        this.value = new LottoNumberGenerator().create(LottoGameView.enterLottoAmount());
        this.purchaseAmount = new PurchaseAmount(lottoAmount);
    }

    public List<LottoNumbers> getValue() {
        return value;
    }

    public LottoGameResult getResult(WinningNumbers winningNumbers) {
        List<Rank> ranks = value.stream()
                .map(winningNumbers::getRank)
                .collect(Collectors.toList());

        return new LottoGameResult(new Ranks(ranks), this.purchaseAmount);
    }
}
