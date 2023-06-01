package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private List<Number> numbers;

    public Numbers(String[] strings) {
        numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(Number.createNumber(string.trim()));
        }
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
