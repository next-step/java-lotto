package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeInputView {
    private String value;

    public PrizeInputView(String inputValue) {
        validation(inputValue);
        this.value = inputValue;
    }

    private void validation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException();
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertToIntCollection() {
        return Arrays.asList(this.value.split(","))
                .stream()
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }
}
