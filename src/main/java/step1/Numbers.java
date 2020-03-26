package step1;

import java.util.List;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int addAll() {
        int result = 0;

        for(int number : numbers) {
            result = result + number;
        }

        return result;
    }
}
