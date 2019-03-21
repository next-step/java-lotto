package lottery.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lottery {
    private List<Integer> numbers = new ArrayList<>();

    public Lottery(List<Integer> numbers) {
        numbers.forEach(number -> {
            this.numbers.add(number);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
