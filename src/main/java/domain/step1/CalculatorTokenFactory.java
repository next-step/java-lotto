package domain.step1;

import java.util.List;

public interface CalculatorTokenFactory {
    <T> List<T> extractList(String[] splits);
}
