package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
        int size = purchaseAmount/1000;

        for (int i = 0; i < size; ++i) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }

        return new Lottos(lottos, purchaseAmount);
    }

    public LottoGameResult matchNumbers(List<Integer> numbers) {
        LottoGameResult lottoGameResult = new LottoGameResult(purchaseAmount);

        for (Lotto lotto : lottos) {
            lottoGameResult.addMatchResult(lotto.hasWinningNumbers(numbers));
        }

        return lottoGameResult;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto);
        }

        return stringBuilder.toString();
    }
}
