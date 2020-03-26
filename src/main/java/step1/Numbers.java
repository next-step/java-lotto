package step1;

import java.util.List;

public class Numbers {

    private static final int INIT_VALUE = 0;

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int addAll() {
        int result = INIT_VALUE;

        for(int number : numbers) {
            result = result + number;
        }

        return result;
    }
}
