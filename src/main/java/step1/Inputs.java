package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inputs {
    private final List<Delimiter> delimiters;
    private final List<InputNumber> numbers;

    private Inputs(List<Delimiter> delimiters, List<InputNumber> numbers) {
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

        return new Inputs(delimiters, inputNumbers);
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

        return new Inputs(delimiters, inputNumbers);
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
