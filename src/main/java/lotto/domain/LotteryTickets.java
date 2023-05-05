package lotto.domain;

import lotto.utility.NumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LotteryTickets {
    private List<Lotto> lottoBundle;

    private int investment;

    public void purchase(int numberOfPurchase) {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i<numberOfPurchase; i++) {
            lottoList.add(new Lotto());
            this.investment += Lotto.PRICE;
        }

        this.lottoBundle = new ArrayList<>(lottoList);
    }

    public List<Lotto> getLottoBundle() {
        return new ArrayList<>(this.lottoBundle);
    }

    public int getInvestment() {
        return this.investment;
    }

}
