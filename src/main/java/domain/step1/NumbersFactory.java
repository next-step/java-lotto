package domain.step1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersFactory implements CalculatorTokenFactory {

    @Override
    public List<Integer> extractList(String[] splits) {
        return IntStream.range(0, splits.length)
                .filter(i -> isNumberPosition(i))
                .mapToObj(i -> Integer.parseInt(splits[i]))
                .collect(Collectors.toList());
    }

    private boolean isNumberPosition(int index) {
        return index % 2 == 0;
    }

}
