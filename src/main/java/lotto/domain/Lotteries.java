package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries() {
        this.lotteries = new ArrayList<>();
    }

    public Lotteries addLottery(Lottery lottery) {
        this.lotteries.add(lottery);
        return this;
    }

    public void add(Lottery lottery) {
        this.lotteries.add(lottery);
    }

    public Lottery get(int index) {
        return this.lotteries.get(index);
    }

    public int size() {
        return this.lotteries.size();
    }

    public void addAll(Lotteries lotteries) {
        for (int i = 0; i < lotteries.size(); i++) {
            this.lotteries.add(lotteries.get(i));
        }
    }

    public StringBuilder toStringLotteries() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lottery lottery : this.lotteries) {
            stringBuilder.append(lottery.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }
}
