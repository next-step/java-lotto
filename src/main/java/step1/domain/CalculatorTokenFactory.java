package step1.domain;

import java.util.List;

public interface CalculatorTokenFactory {
    <T> List<T> extractList(String[] splits);
}
