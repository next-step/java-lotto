package lottery_auto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Lotteries {
    private List<Lottery> lotteryList;

    public Lotteries(final List<Lottery> lotteryList) {
        this.lotteryList = lotteryList;
    }

    public WinningResult countMatchNumber(final List<Integer> winningNumber){
        List<Integer> result = lotteryList.stream()
                               .map(lottery -> lottery.compare(winningNumber))
                               .collect(Collectors.toList());

        return new WinningResult(result);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        lotteryList.stream()
                .map(Lottery::toString)
                .map(lottery -> lottery + System.lineSeparator())
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
