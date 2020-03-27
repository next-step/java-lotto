package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomNumbers {
    private List<CustomNumber> customNumbers;

    public CustomNumbers(List<CustomNumber> customNumbers) {
        this.customNumbers = Collections.unmodifiableList(customNumbers);
    }

    public CustomNumbers(String[] input) {
        List<CustomNumber> result = new ArrayList<>();
        for (String s : input) {
            result.add(CustomNumber.of(Integer.parseInt(s)));
        }
        this.customNumbers = result;
    }

    public List<CustomNumber> getCustomNumbers() {
        return customNumbers;
    }

    public int sum() {
        return customNumbers.stream()
                .mapToInt(CustomNumber::getNumber)
                .sum();
    }
}
