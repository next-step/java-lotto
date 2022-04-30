package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int userAmount;
    private final List<LottoNumbers> lottos;

    public Lottos(int userAmount) {
        this(userAmount, getRandomLottoNumbers(userAmount));
    }

    protected Lottos(List<LottoNumbers> lottos) {
        this(lottos.size() * LOTTO_PRICE, lottos);
    }

    protected Lottos(int userAmount, List<LottoNumbers> lottos) {
        this.userAmount = userAmount;
        this.lottos = lottos;
    }

    private static List<LottoNumbers> getRandomLottoNumbers(int userAmount) {
        return IntStream.range(START_INCLUSIVE, userAmount / LOTTO_PRICE)
                .mapToObj(it -> LottoNumbers.ofRandom())
                .collect(Collectors.toList());
    }

    public int length() {
        return this.lottos.size();
    }

    public void print() {
        this.lottos.stream()
                .map(LottoNumbers::toString)
                .forEach(System.out::println);
    }

    public List<Integer> getMatchNumberCounts(LottoNumbers lottos) {
        return this.lottos.stream()
                .map(lottos::getMatchNumberCount)
                .collect(Collectors.toList());
    }

    public double getRevenueRate(LottoNumbers lottoNumbers) {
        int sum = this.getMatchNumberCounts(lottoNumbers).stream()
                .map(MatchCount::getWinningAmountWith)
                .reduce(Integer::sum)
                .orElseThrow(IllegalArgumentException::new);

        return sum / this.userAmount;
    }
}
