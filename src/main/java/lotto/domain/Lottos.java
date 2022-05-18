package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import static lotto.domain.Lotto.LOTTO_PRICE;
import lotto.domain.result.LottoGameResult;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int size = purchaseAmount/LOTTO_PRICE;

        for (int i = 0; i < size; ++i) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }

        return new Lottos(lottos);
    }

    public static Lottos of(int purchaseAmount, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        int size = purchaseAmount/LOTTO_PRICE - manualLottos.size();

        for (int i = 0; i < size; ++i) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }

        return new Lottos(lottos);
    }

    public LottoGameResult matchNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        LottoGameResult lottoGameResult = new LottoGameResult(LOTTO_PRICE * lottos.size());

        for (Lotto lotto : lottos) {
            lottoGameResult.addMatchResult(lotto.hasWinningNumbers(winningLotto, bonusNumber));
        }

        return lottoGameResult;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
