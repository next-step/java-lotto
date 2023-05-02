package domain;

import java.util.List;

public interface CalculatorTokenFactory {
    <T> List<T> extractList(String[] splits);
}
