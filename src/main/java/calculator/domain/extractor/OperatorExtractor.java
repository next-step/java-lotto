package calculator.domain.extractor;

import calculator.domain.Operator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperatorExtractor implements Extractor<List<Operator>> {

    private static final int ODD_REMAIN_RESULT = 1;
    private static final int INDEX_DIVIDE_NUMBER = 2;
    private static final int INITIAL_INDEX = 0;

    @Override
    public List<Operator> extract(List<String> inputList) {

        return IntStream.range(INITIAL_INDEX, inputList.size())
                .filter(this::isOdd)
                .mapToObj(index-> toOperator(index,inputList))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isOdd(int index) {
        return index % INDEX_DIVIDE_NUMBER == ODD_REMAIN_RESULT;
    }

    private Operator toOperator(int index, List<String> inputList) {
        String input = inputList.get(index);
        return Operator.lookUp(input);
    }
}
