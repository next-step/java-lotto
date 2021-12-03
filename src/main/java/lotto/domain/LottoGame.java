package lotto.domain;

import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;


public class LottoGame {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MIN_BUY_ROUND = 1;

    private final int purchaseAmount;
    private final int buyRound;
    private final Lottos lottos;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.buyRound = getBuyRound();
        this.lottos = new Lottos(buyRound);
    }

    public int getBuyRound() {
        validatePurchaseAmount(purchaseAmount);
        int buyRound = purchaseAmount / MIN_PURCHASE_AMOUNT;
        return buyRound;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount / MIN_PURCHASE_AMOUNT < MIN_BUY_ROUND){
            throw new IllegalArgumentException("1000원 이상 입력되어야 합니다.");
        }
    }

    public LottoDto getLottos() {
        return new LottoDto(lottos.getLottos());
    }

    public StatisticsDto getResultStatics(String winLottoNumbers){
        Lotto winLotto = new Lotto(winLottoNumbers);
//        List<Rank> ranks = lottos.compareWinLotto(winLotto);
        return null;
    }

}
