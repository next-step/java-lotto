package calculator;

public interface CalculateStrategy {

    boolean support(String separator);

    void calculate(Number number, String target);

}
