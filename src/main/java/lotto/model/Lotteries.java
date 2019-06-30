package lotto.model;

import java.util.List;

public class Lotteries {


    private List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return this.lotteries;
    }
}
