package lotto.model;

import java.util.List;

public class Lotteries {

    private List<LottoNumbers> lotteries;

    public Lotteries(List<LottoNumbers> lotteries) {
        this.lotteries = lotteries;
    }

    public List<LottoNumbers> getLotteries() {
        return this.lotteries;
    }
}
