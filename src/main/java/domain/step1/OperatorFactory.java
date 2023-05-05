package domain.step1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperatorFactory implements CalculatorTokenFactory {

    @Override
    public List<Operator> extractList(String[] splits) {
        return IntStream.range(0, splits.length)
                .filter(i -> isOperatorPosition(i))
                .mapToObj(i -> Operator.toOperation(splits[i]))
                .collect(Collectors.toList());
    }

    private boolean isOperatorPosition(int index) {
        return index % 2 != 0;
    }
}
