package stringcaculator.domain;

import java.util.Objects;

public class Input {
    public final String value;

    public Input(String value) {
        this.value = value;
    }

    public Input validValue() {
        if(this.value == null || this.value.trim().isEmpty()) {
            return new Input("0");
        }
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public String[] splitedInput(DelimiterRegex regex) {
        return this.value.split(regex.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Input)) return false;
        Input input = (Input) o;
        return this.value.equals(input.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}