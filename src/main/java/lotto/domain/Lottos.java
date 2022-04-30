package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(int userAmount) {
        this(getRandomLottoNumbers(userAmount));
    }

    protected Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static List<LottoNumbers> getRandomLottoNumbers(int userAmount) {
        return IntStream.range(START_INCLUSIVE, userAmount / LOTTO_PRICE)
                .mapToObj(it -> new LottoNumbers())
                .collect(Collectors.toList());
    }

    public int length() {
        return this.lottoNumbers.size();
    }

    public void print() {
        this.lottoNumbers.stream()
                .map(LottoNumbers::toString)
                .forEach(System.out::println);
    }

    public List<Integer> getMatchNumberCounts(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.stream()
                .map(lottoNumbers::getMatchNumberCount)
                .collect(Collectors.toList());
    }
}
