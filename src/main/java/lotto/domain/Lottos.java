package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static lotto.domain.Lotto.LOTTO_PRICE;
import lotto.domain.result.LottoGameResult;

public class Lottos {
    private List<Lotto> lottos;
    private int purchaseAmount;

    Lottos(List<Lotto> lottos, int purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public static Lottos of(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int size = purchaseAmount/LOTTO_PRICE;

        for (int i = 0; i < size; ++i) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }

        return new Lottos(lottos, purchaseAmount);
    }

    public LottoGameResult matchNumbers(Set<Integer> numbers, int bonusNumber) {
        LottoGameResult lottoGameResult = new LottoGameResult(purchaseAmount);

        for (Lotto lotto : lottos) {
            lottoGameResult.addMatchResult(lotto.hasWinningNumbers(numbers, bonusNumber));
        }

        return lottoGameResult;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
