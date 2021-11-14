package lotto.step2.domain;

import java.util.*;

public class LotteryCompany {

    private Lotteries lotteries;
    private List<Integer> winningNumbers = new ArrayList<>();
    public static final Map<Integer, Integer> prizeMoney = createMap();

    public LotteryCompany() {}

    public LotteryCompany(String winningNumbers, Lotteries lotteries) {
        setWinningNumbers(winningNumbers);
        this.lotteries = lotteries;
    }
    //테스트 편의 생성자
    public LotteryCompany(String winningNumbers) {
        setWinningNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getTotalCountOfMatch(int expected) {
        return (int) lotteries.getLotteries().stream()
                .filter(lotto -> lotto.isMatchExpected(winningNumbers, expected))
                .count();
    }

    private static Map<Integer, Integer> createMap() {
        Map<Integer, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(3, 500);
        prizeMoney.put(4, 50000);
        prizeMoney.put(5, 15000000);
        prizeMoney.put(6, 2000000000);
        return prizeMoney;
    }

    private void setWinningNumbers(String input) {
        Arrays.stream(input.split(","))
                .forEach(s -> winningNumbers.add(Integer.valueOf(s.trim())));
    }

}
