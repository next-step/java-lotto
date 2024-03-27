package lottery.domain;

import lottery.code.WinPrizeType;
import lottery.domain.vo.LotteryNumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries(Long lotteryCount) {
        this(dispense(lotteryCount));
    }
    public Lotteries(int moneyAmount) {
        this(lotteryCount(moneyAmount));
    }

    public Map<WinPrizeType, Long> winStatistics(WinLottery winLottery) {
        return this.lotteries.stream()
                .collect(Collectors.groupingBy(
                        lottery -> WinPrizeType.fromMatchCount(lottery.matchNumbersCount(winLottery.winLottery())),
                        Collectors.counting()));
    }

    public Long lotteryCount(){
        return Long.valueOf(this.lotteries.size());
    }

    public List<Lottery> lotteries() {
        return Collections.unmodifiableList(lotteries);
    }

    public int lotteriesTotalPrice(){
        return this.lotteries.size() * 1000;
    }

    public int lotteriesTotalPrize(Map<WinPrizeType, Long> matchStatistics){
        return matchStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().prize() * entry.getValue().intValue())
                .sum();
    }

    private static Long lotteryCount(int amountMoney){
        return Long.valueOf(amountMoney / 1000);
    }

    private static List<Lottery> dispense(Long lotteryCount) {
        List<Lottery> lotteries = new ArrayList<>();
        for(int count = 0; count < lotteryCount; count++){
            lotteries.add(new Lottery(quickPick()));
        }
        return Collections.unmodifiableList(lotteries);
    }

    private static LotteryNumbers quickPick(){
        List<Integer> allNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(allNumbers);
        List<Integer> lotteryNumbers = allNumbers.subList(0, 6);
        Collections.sort(lotteryNumbers);
        return new LotteryNumbers(new HashSet<>(lotteryNumbers));
    }
}
