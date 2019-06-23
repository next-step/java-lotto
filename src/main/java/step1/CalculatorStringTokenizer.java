package step1;

import java.util.List;

public abstract class CalculatorStringTokenizer {
    protected final String value;

    public CalculatorStringTokenizer(String value) {
        this.value = value;
    }

    abstract List<String> split();
}
