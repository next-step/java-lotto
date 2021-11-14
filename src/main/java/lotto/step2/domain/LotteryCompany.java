package lotto.step2.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LotteryCompany {

    private static final String COMMA = ",";
    private static final String RATE_PATTERN = "0.##";
    private final Map<Integer, Integer> prizeMoney = new HashMap<>();
    private final List<Integer> winningNumbers = new ArrayList<>();
    private Lotteries lotteries;

    public LotteryCompany(String winningNumbers) {
        setPrizeMoney();
        setWinningNumbers(winningNumbers);
    }

    public LotteryCompany(String winningNumbers, Lotteries lotteries) {
        this(winningNumbers);
        this.lotteries = lotteries;
    }

    public Map<Integer, Integer> getPrizeMoney() {
        return prizeMoney;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getTotalCountOfMatch(int expected) {
        return (int) lotteries.getLotteries().stream()
                .filter(lotto -> lotto.isMatchExpected(winningNumbers, expected))
                .count();
    }

    public double getRateOfReturn(int orderPrice) {
        DecimalFormat decimalFormat = new DecimalFormat(RATE_PATTERN);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(decimalFormat.format(calculateRateOfReturn() / orderPrice));
    }

    private void setPrizeMoney() {
        prizeMoney.put(3, 5000);
        prizeMoney.put(4, 50000);
        prizeMoney.put(5, 15000000);
        prizeMoney.put(6, 2000000000);
    }

    private void setWinningNumbers(String input) {
        Arrays.stream(input.split(COMMA))
                .forEach(s -> winningNumbers.add(Integer.valueOf(s.trim())));
    }

    private double calculateRateOfReturn() {
        double money = 0;
        for (int index = 3; index <= 6; index++) {
            int totalCountOfMatch = getTotalCountOfMatch(index);
            money = sumMoney(money, totalCountOfMatch, index);
        }
        return money;
    }

    private double sumMoney(double money, int totalCountOfMatch, int index) {
        if (totalCountOfMatch > 0) {
            money = prizeMoney.get(index) * totalCountOfMatch;
        }
        return money;
    }

}
