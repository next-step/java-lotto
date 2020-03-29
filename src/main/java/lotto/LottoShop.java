package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int PRICE_PER_PIECE = 1000;
    private LottoBundle lottoBundle;

    public LottoShop() {
    }

    public LottoShop(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public void buyAuto(int price) {
        validatePrice(price);
        int lottoCount = Math.floorDiv(price, PRICE_PER_PIECE);
        lottoBundle = new LottoBundle(toList(lottoCount));
    }

    private List<Lotto> toList(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private void validatePrice(int price) {
        if (price < PRICE_PER_PIECE) {
            throw new IllegalArgumentException("로또 가격은 1000원 이상이어야 합니다.");
        }
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }

    public LottoResult checkWinning(String winningNumber, int bonusNumber) {
        List<WinningType> winningTypes = lottoBundle.drawForWinning(winningNumber, bonusNumber);
        return new LottoResult(winningTypes, lottoBundle.size());
    }
}
