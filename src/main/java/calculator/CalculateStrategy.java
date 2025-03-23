package calculator;

import java.math.BigDecimal;
import java.util.List;

public interface CalculateStrategy {
    BigDecimal calculate(List<String> tokens);
}
