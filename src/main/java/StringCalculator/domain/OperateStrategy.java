package StringCalculator.domain;

import java.util.List;

public interface OperateStrategy {

    int operate(List<Integer> operands);
}
