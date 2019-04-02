package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int lotterySize = lotteries.size();
        for (int i = 0; i < lotterySize; i++) {
            this.lotteries.add(lotteries.get(i));
        }
    }

    public String toStringLotteries() {
    return lotteries.stream()
            .map(lottery -> lottery.toString())
            .collect(Collectors.joining("\n"));
    }
}
