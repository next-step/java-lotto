package step1.domain;

public interface Operator {

    boolean supports(String rawOperator);

    Operand operate(Operand operand1, Operand operand2);
}
