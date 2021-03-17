package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private NumberGenerator numberGenerator;
    private List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.numbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numberGenerator.getGeneratedNumbers(numbers);
    }
}
