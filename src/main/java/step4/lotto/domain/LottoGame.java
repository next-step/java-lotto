package step4.lotto.domain;

import step4.lotto.domain.numbers.LottoTicket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private LottoShop lottoShop = new LottoShop();
    private Set<LottoTicket> buyLottoHashSet = new HashSet<>();

    private LottoTicketCount lottoTicketCount;

    public LottoGame(int purchaseAmount, int lottoManualBuyCount) {
        this.lottoTicketCount = new LottoTicketCount(purchaseAmount, lottoManualBuyCount);
    }

    public void getLottoResult(String winningNumbers, int bonusNumber) {
        LottoMatch lottoMatch = new LottoMatch(winningNumbers, buyLottoHashSet, bonusNumber);
        lottoMatch.playLottoMatch();
    }

    public void buyManualLotto(List<String> manualLottoList) {
        if (lottoTicketCount.getLottoManualBuyCount() > 0) {
            Set<LottoTicket> buyManualLotto = lottoShop.buyManualLotto(manualLottoList, lottoTicketCount.getLottoManualBuyCount());
            buyLottoHashSet.addAll(buyManualLotto);
        }
    }

    public void buyAutoLotto() {
        if ((lottoTicketCount.getLottoPurchaseAmount() / 1000) - lottoTicketCount.getLottoManualBuyCount() > 0) {
            Set<LottoTicket> buyAutoLotto = lottoShop.buyAutoLotto(lottoTicketCount.getLottoAutoBuyCount());
            buyLottoHashSet.addAll(buyAutoLotto);
        }
    }

    public Set<LottoTicket> getBuyLottoHashSet() {
        return buyLottoHashSet;
    }


    public LottoTicketCount getLottoTicketCount() {
        return lottoTicketCount;
    }
}
