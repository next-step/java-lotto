package calculator.domain;

import java.util.Objects;

public class Content {
    private final Integer number;
    private final String operation;

    public Content(String str) {
        if (isNumber(str)) {
            this.operation = null;
            this.number = Integer.parseInt(str);
            return;
        }

        if (isOperation(str)) {
            this.operation = str;
            this.number = null;
            return;
        }

        throw new IllegalArgumentException("숫자 또는 사칙연산 기호가 아닙니다.");
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

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isOperation(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }
}
