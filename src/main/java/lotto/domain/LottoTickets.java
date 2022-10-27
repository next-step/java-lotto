package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static lotto.util.NumberUtil.makeAutoNumberList;

public class LottoTickets {

    private final PurchaseInfo purchaseInfo;
    private List<Lotto> lottoList;

    public LottoTickets(PurchaseInfo purchaseInfo, List<Lotto> lottoList) {
        this(purchaseInfo);
        this.lottoList = lottoList;
    }

    public LottoTickets(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public LottoTickets pickNumbers(List<Integer> manualLottoList) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < this.purchaseInfo.getAutoAmount(); i++) {
            lottoList.add(new Lotto(makeAutoNumberList()));
        }

        for (int i = 0; i < this.purchaseInfo.getManualAmount(); i++) {
            lottoList.add(new Lotto(manualLottoList));
        }

        this.lottoList = lottoList;
        return this;
    }

    public List<Rank> putRankings(LottoResult winnerLottoResult) {
        List<Rank> rankList = new ArrayList<>();
        this.lottoList.forEach(l -> rankList.add(l.rank(winnerLottoResult)));
        return rankList;
    }

    public BigDecimal getYield(List<Rank> rankList) {
        int totalWinningMoney = rankList.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
        return BigDecimal.valueOf(totalWinningMoney)
                .divide(BigDecimal.valueOf(this.purchaseInfo.getPurchasePrice()), 2, RoundingMode.HALF_UP);
    }

}
