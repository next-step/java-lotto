package calculator.domain;

import java.util.Objects;

public class Content {
    private final Integer number;
    private final String operation;

    public Content(Integer number) {
        this.number = number;
        this.operation = null;
    }

    public Content(String operation) {
        this.operation = operation;
        this.number = null;
    }

    public int getNumber() {
        return number;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;

        Content content = (Content) o;

        if (!Objects.equals(number, content.number)) return false;
        return Objects.equals(operation, content.operation);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}
