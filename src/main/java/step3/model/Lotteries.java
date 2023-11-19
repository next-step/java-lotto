package step3.model;

import java.util.ArrayList;
import java.util.List;

import step3.domain.Lottery;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public void keep(Lottery lottery) {
        lotteries.add(lottery);
    }
}
