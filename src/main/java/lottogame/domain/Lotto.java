package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int getPrize(Lotto lotto) {
        return Rank.findPrize(match(lotto));
    }

    public Rank getRank(Lotto lotto) {
        return Rank.findRank(match(lotto));
    }

    private int match(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::match)
                .count();
    }

    private boolean match(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoNumber number : numbers) {
            stringBuilder.append(number).append(", ");
        }

        return "["+stringBuilder.toString().replaceAll(", $", "")+"]";
    }
}
