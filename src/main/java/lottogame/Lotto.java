package lottogame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.numbergenerator.NumberGenerator;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int match(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::match)
                .count();
    }

    public int getPrize(Lotto lotto) {
        return Rank.findPrize(match(lotto));
    }

    private boolean match(int number) {
        return numbers.contains(number);
    }
}
