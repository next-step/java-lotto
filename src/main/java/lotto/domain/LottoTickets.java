package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.LottoNumber.getAutoNumberList;

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

    public LottoTickets pickNumbers() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchasePrice.getAmount(); i++) {
            lottoList.add(new Lotto(getAutoNumberList()));
        }

        this.lottoList = lottoList;
        return this;
    }

    public Integer getPurchasePrice() {
        return purchasePrice.getPurchasePrice();
    }

    public LottoTickets putRankings(List<Integer> matchNumberList) {
        lottoList.forEach(l -> l.rank(matchNumberList));
        return this;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
