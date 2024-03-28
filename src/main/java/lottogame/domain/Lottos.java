package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> numbers;

    public Lottos(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Number getPrize(Lottos lotto) {
        return Number.from(Rank.findPrize(match(lotto)));
    }

    public Rank getRank(Lottos lotto) {
        return Rank.findRank(match(lotto));
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    protected int match(Lottos lotto) {
        return (int) numbers.stream()
                .filter(lotto::match)
                .count();
    }

    protected boolean match(LottoNumber number) {
        return numbers.contains(number);
    }
}
