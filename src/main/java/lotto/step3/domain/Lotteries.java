package lotto.step3.domain;

import java.util.List;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries(int lottoCount) {

    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }
}
