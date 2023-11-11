package step1.domain.operator;

public interface Operator {

    int operate(int first, int second);
    boolean supports(String operator);
}
