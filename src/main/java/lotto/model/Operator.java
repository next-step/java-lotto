package lotto.model;

public interface Operator {

    Number add(Number right);

    Number subtract(Number right);

    Number multiply(Number right);

    Number divide(Number right);
}
