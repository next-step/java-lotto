package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.LottoNumber.getAutoNumberList;

public class LottoTickets {

    private final Integer amount;
    private final Integer purchasePrice;
    private List<Lotto> lottoList;

    public LottoTickets(Integer amount, Integer purchasePrice) {
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    public LottoTickets(Integer amount, Integer purchasePrice, List<Lotto> lottoList) {
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.lottoList = lottoList;
    }

    public LottoTickets pickNumbers() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(getAutoNumberList()));
        }

        this.lottoList = lottoList;
        return this;
    }

    public LottoTickets putRankings(List<Integer> matchNumberList) {
        lottoList.forEach(l -> l.rank(matchNumberList));
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
