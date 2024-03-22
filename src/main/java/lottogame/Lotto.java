package lottogame;

import java.util.ArrayList;
import java.util.List;
import utils.numbergenerator.NumberGenerator;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
