package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static lotto.util.NumberUtil.makeAutoNumberList;

public class LottoTickets {

    private final PurchasePrice purchasePrice;
    private List<Lotto> lottoList;

    public LottoTickets(PurchasePrice purchasePrice, List<Lotto> lottoList) {
        this(purchasePrice);
        this.lottoList = lottoList;
    }

    public LottoTickets(PurchasePrice purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public LottoTickets pickNumbers() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < this.purchasePrice.getAmount(); i++) {
            lottoList.add(new Lotto(makeAutoNumberList()));
        }

        this.lottoList = lottoList;
        return this;
    }

    public List<Rank> putRankings(LottoNumbers winnerLottoNumbers) {
        List<Rank> rankList = new ArrayList<>();
        this.lottoList.forEach(l -> rankList.add(l.rank(winnerLottoNumbers)));
        return rankList;
    }

    public BigDecimal getYield(List<Rank> rankList) {
        int totalWinningMoney = rankList.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
        return BigDecimal.valueOf(totalWinningMoney)
                .divide(BigDecimal.valueOf(this.purchasePrice.getPurchasePrice()), 2, RoundingMode.HALF_UP);
    }

}
