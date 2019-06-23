package step1;

import java.util.List;

public class DefaultCalculatorStringTokenizer extends CalculatorStringTokenizer {

    public DefaultCalculatorStringTokenizer(String value) {
        super(value);
    }

    @Override
    public List<String> split() {
        return List.of(value.split(",|:"));
    }
}
