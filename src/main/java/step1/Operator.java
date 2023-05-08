package step1;

import java.util.ArrayList;
import java.util.List;

public class Operator {
    private List<String> operator = new ArrayList<>();

    public void add(String string) {
        this.operator.add(string);
    }

    public void setOperators(String s) {
        if (!isValidOperator(s)) {
            throw new IllegalArgumentException("사칙연산 기호만(+ - * /) 입력해주세요.");
        }
        this.operator.add(s);
    }

    private boolean isValidOperator(String string) {

        return string.matches("^[*/+-]+$");
    }

    public String get(int index) {
        return operator.get(index);
    }

    public int size() {
        return operator.size();
    }
}
