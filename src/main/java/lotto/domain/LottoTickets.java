package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            lottoList.add(new Lotto());
        }

        this.lottoList = lottoList;
        return this;
    }

    public LottoTickets putRankings(LottoNumbers winnerLottoNumbers) {
        this.lottoList.forEach(l -> l.rank(winnerLottoNumbers));
        return this;
    }

    public List<Rank> getRank() {
        return this.lottoList
                .stream()
                .map(Lotto::getRank)
                .collect(Collectors.toList());
    }

    public Integer getYield() {
        int totalWinningMoney = this.lottoList
                .stream()
                .mapToInt(l -> l.getRank().getWinningMoney())
                .sum();
        return totalWinningMoney / this.purchasePrice.getPurchasePrice();
    }

}
