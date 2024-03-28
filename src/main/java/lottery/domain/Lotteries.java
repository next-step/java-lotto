package lottery.domain;

import lottery.code.WinPrizeType;
import lottery.domain.vo.LotteryNumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries(Long lotteryCount) {
        this(dispense(lotteryCount));
    }
    public Lotteries(Integer moneyAmount) {
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

    public Integer lotteriesTotalPrice(){
        return this.lotteries.size() * Lottery.PRICE;
    }

    public Integer lotteriesTotalPrize(Map<WinPrizeType, Long> matchStatistics){
        return matchStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().prize() * entry.getValue().intValue())
                .sum();
    }

    private static Long lotteryCount(Integer inputMoney){
        validateMoney(inputMoney);
        return Long.valueOf(inputMoney / Lottery.PRICE);
    }

    private static void validateMoney(Integer inputMoney){
        if(Objects.isNull(inputMoney))
            throw new IllegalArgumentException("구입 금액은 필수 입니다.");
        if(inputMoney % Lottery.PRICE != 0)
            throw new IllegalArgumentException("구입 금액은 1000 단위 입니다.");
    }

    private static List<Lottery> dispense(Long lotteryCount) {
        return LongStream.range(0, lotteryCount)
                .mapToObj(count -> new Lottery(quickPick()))
                .collect(Collectors.toUnmodifiableList());
    }

    private static LotteryNumbers quickPick(){
        Collections.shuffle(LotteryNumbers.ALL_LIST);
        List<Integer> lotteryNumbers = LotteryNumbers.ALL_LIST.subList(0, LotteryNumbers.SIZE);
        Collections.sort(lotteryNumbers);
        return new LotteryNumbers(new HashSet<>(lotteryNumbers));
    }
}
