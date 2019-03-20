package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Winning {
    private List<Number> numbers = new ArrayList();

    public Winning(String number) {
        split(number).forEach(v -> numbers.add(new Number(toInt(v))));
    }

    private int toInt(String v) {
        return Integer.parseInt(v);
    }

    private Stream<String> split(String number) {
        return Arrays.stream(number.split(", "));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int compare(List<Number> numbers) {
        return (int) this.numbers.stream().filter(numbers::contains).count();
    }
}
