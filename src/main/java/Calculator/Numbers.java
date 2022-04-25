package Calculator;

import java.util.List;

public class Numbers {

    private int index;
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.index = 0;
        this.numbers = numbers;
    }

    public Integer next() {
        return numbers.get(index);
    }
}
