package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int purchaseAmount) {
        this(purchaseAmount, new SimpleNumberGenerator());
    }

    public Lottos(int purchaseAmount, NumberGenerator numberGenerator) {
        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(new Lotto(numberGenerator.generateNumbers()));
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList.addAll(lottoList);
    }

    public int getAmount() {
        return lottoList.size();
    }

    public LottosTotalResult getResult(List<Integer> winningNumbers) {
        LottosTotalResult lottosTotalResult = new LottosTotalResult();
        for (Lotto lotto : lottoList) {
            lottosTotalResult.plusOne(lotto.countMatched(winningNumbers));
        }
        return lottosTotalResult;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
