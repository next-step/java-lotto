package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final Integer PRICE = 1000;

    private final LottoGenerateStrategy lottoPickStrategy;

    public LottoStore(LottoGenerateStrategy lottoPickStrategy) {
        this.lottoPickStrategy = lottoPickStrategy;
    }

    public PickedLottoNumbers buy(Money money) {
        List<LottoNumbers> pickedLottoNumbers = new ArrayList<>();
        int totalCount = money.getMoney() / PRICE;

        for (int count = 0; count < totalCount; count++) {
            pickedLottoNumbers.add(lottoPickStrategy.generateLottoNumbers());
        }
        return new PickedLottoNumbers(pickedLottoNumbers);
    }
}