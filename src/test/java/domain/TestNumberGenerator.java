package domain;

import java.util.ArrayList;
import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private List<Integer> numbers;

    @Override
    public List<Integer> getRandomNumber() {
        return numbers;
    }

    public void setRandomNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

}
