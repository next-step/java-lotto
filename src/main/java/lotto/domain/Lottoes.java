package lotto.domain;

import lotto.constant.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {

    private final List<LottoNumbers> value;

    public Lottoes(List<LottoNumbers> value) {
        this.value = value;
    }

    public List<LottoNumbers> getValue() {
        return value;
    }

    public LottoGameResult getResult(LottoNumbers winningNumbers) {
        List<Rank> collect = value.stream()
                .map(winningNumbers::getRank)
                .collect(Collectors.toList());

        int purchaseAmount = value.size() * Lotto.PRICE;

        return new LottoGameResult(collect, new PurchaseAmount(purchaseAmount));

    }
}
