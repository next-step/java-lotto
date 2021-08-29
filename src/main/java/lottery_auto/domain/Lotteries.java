package lottery_auto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotteries {
    private List<Lottery> lotteryList;

    public Lotteries(final List<Lottery> lotteryList) {
        this.lotteryList = lotteryList;
    }

    public WinningResult countMatchNumber(final String winningNumber){
        List<Integer> result = lotteryList.stream()
                               .map(lottery -> lottery.compare(disposeNumber(winningNumber)))
                               .collect(Collectors.toList());

        return new WinningResult(result);
    }

    private List<Integer> disposeNumber(String winningNumbers){
        validateInput(winningNumbers);

        return Arrays.stream(winningNumbers.split(", "))
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .collect(Collectors.toList());

    }

    private void validateInput(String winningNumber){
        if(winningNumber.isEmpty() || winningNumber == null){
            throw new IllegalArgumentException("");
        }
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
