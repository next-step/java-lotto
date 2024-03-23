package lottogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.numbergenerator.NumberGenerator;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int match(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::match)
                .count();
    }

    public int getPrize(Lotto lotto) {
        return Rank.findPrize(match(lotto));
    }

    private boolean match(LottoNumber number) {
        return numbers.contains(number);
    }
}
