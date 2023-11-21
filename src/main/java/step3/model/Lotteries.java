package step3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public void setWin(String numberStr) {
        String[] split = numberStr.replaceAll(" ", "")
                                  .split(",");
        List<Integer> win = Arrays.stream(split)
                                  .map(Integer::parseInt)
                                  .collect(Collectors.toList());

        lotteries.forEach(lottery -> lottery.setWin(win));
    }
}
