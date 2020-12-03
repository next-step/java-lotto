package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {

    private final List<LottoNumbers> value;
    private final PurchaseAmount purchaseAmount;

    //TODO Test를 위한 생성자를 만들었는데, 이래도 되는지 의문...
    public Lottoes(List<LottoNumbers> value, PurchaseAmount purchaseAmount) {
        this.value = value;
        this.purchaseAmount = purchaseAmount;
    }

    public Lottoes(int lottoAmount) {
        this.value = new LottoNumberGenerator().create(lottoAmount);
        this.purchaseAmount = new PurchaseAmount(lottoAmount);
    }

    public List<LottoNumbers> getValue() {
        return Collections.unmodifiableList(value);
    }

    public LottoGameResult getResult(WinningNumbers winningNumbers) {
        List<Rank> ranks = value.stream()
                .map(winningNumbers::getRank)
                .collect(Collectors.toList());

        return new LottoGameResult(new Ranks(ranks), this.purchaseAmount);
    }
}
