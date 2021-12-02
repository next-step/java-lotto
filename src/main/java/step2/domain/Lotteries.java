package step2.domain;

import step2.domain.enums.RANKING;
import step2.domain.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotteries.add(new Lottery(RandomUtil.getRandomNumbers()
                    .stream()
                    .map(n -> Number.createFromInt(n))
                    .collect(Collectors.toList())));
        }

        this.lotteries = lotteries;
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getList() {
        return lotteries;
    }

    public Map<RANKING, Integer> getStaticResult(Lottery winningNumbers) {
        Map<RANKING, Integer> statisticResult = new LinkedHashMap() {{
            for (int idx = 3; idx <= 6; idx++) {
                put(RANKING.of(idx), 0);
            }
        }};

        for (Lottery lottery : this.lotteries) {
            int count = lottery.correctCount(winningNumbers);
            RANKING key = RANKING.of(count);

            if (statisticResult.containsKey(key)) {
                statisticResult.put(key, statisticResult.get(key) + 1);
            }
        }

        return statisticResult;
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
}
