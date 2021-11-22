package lotto.step3.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Lotteries {

    private static final String RATE_PATTERN = "0.##";

    private final List<Lotto> lotteries;

    public Lotteries(int orderCount) {
        this(range(0, orderCount)
                .mapToObj(i -> new Lotto())
                .collect(toList()));
    }

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public Map<Integer, Integer> createRepository(Lotto winningNumbers) {
        Map<Integer, Integer> repository = new HashMap<>();
        for (Rank rank : Rank.values()) {
            repository.put(rank.getCountOfMatch(), totalCountOfMatch(winningNumbers, rank.getCountOfMatch()));
        }
        return repository;
    }

    public int totalSecondPrizeWinners(Lotto winningNumbers, LottoNumber bonusBall) {
        return (int) lotteries.stream()
                .filter(lotto -> lotto.isSecondPrizeWinner(winningNumbers, bonusBall))
                .count();
    }

    public double calculateRateOfProfit(Lotto winningNumbers, LottoNumber bonusBall, int orderPrice) {
        double totalPrizeMoney = totalPrizeMoney(winningNumbers, bonusBall);
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    private int totalCountOfMatch(Lotto winningNumbers, int count) {
        return (int) lotteries.stream()
                .filter(lotto -> lotto.isCountOfMatch(winningNumbers, count))
                .count();
    }

    private int totalPrizeMoney(Lotto winningNumbers, LottoNumber bonusBall) {
        return lotteries.stream()
                .mapToInt(lotto -> lotto.calculatePrizeMoney(winningNumbers, bonusBall))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + lotteries +
                '}';
    }

}
