package lottogame;

import java.util.List;
import utils.numbergenerator.NumberGenerator;

public class Lotto {
    private List<Integer> numbers;

    private final NumberGenerator numberGenerator;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> create() {
        this.numbers = this.numberGenerator.generate();
        return this.numbers;
    }
}
