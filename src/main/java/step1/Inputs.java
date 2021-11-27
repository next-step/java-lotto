package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inputs {
    private final Delimiters delimiters;
    private final InputNumbers numbers;

    private Inputs(Delimiters delimiters, InputNumbers numbers) {
        this.delimiters = delimiters;
        this.numbers = numbers;
    }

    public static Inputs createWithDelimiter(String s) {
        List<Delimiter> delimiters = new ArrayList<>();
        List<InputNumber> inputNumbers = new ArrayList<>();

        String delimiter = s.substring("//".length(), s.indexOf("\\n"));
        delimiters.add(new Delimiter(delimiter));

        s = s.substring(s.indexOf("\\n") + "\\n".length());

        for (String number : s.split(delimiter)) {
            inputNumbers.add(new InputNumber(Integer.parseInt(number)));
        }

        return new Inputs(new Delimiters(delimiters), new InputNumbers(inputNumbers));
    }

    public static Inputs createWithoutDelimiter(String s) {
        List<Delimiter> delimiters = new ArrayList() {{
            add(",");
            add(":");
        }};

        List<InputNumber> inputNumbers = new ArrayList<>();
        for (String number : s.split(",|:")) {
            inputNumbers.add(new InputNumber(Integer.parseInt(number)));
        }

        return new Inputs(new Delimiters(delimiters), new InputNumbers(inputNumbers));
    }

    public InputNumber sum() {
        return numbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs = (Inputs) o;
        return Objects.equals(delimiters, inputs.delimiters) &&
                Objects.equals(numbers, inputs.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters, numbers);
    }
}
