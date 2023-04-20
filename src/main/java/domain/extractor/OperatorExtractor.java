package domain.extractor;

import domain.Operator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperatorExtractor implements Extractor<List<Operator>> {

    private static final int ODD_REMAIN_RESULT = 1;
    private static final int INDEX_DIVIDE_NUMBER = 2;
    private static final int INITIAL_INDEX = 0;


    @Override
    public List<Operator> extract(List<String> input) {

        return IntStream.range(INITIAL_INDEX, input.size())
                .filter(index -> index % INDEX_DIVIDE_NUMBER == ODD_REMAIN_RESULT)
                .mapToObj(filterIndex -> Operator.lookUp(input.get(filterIndex)))
                .collect(Collectors.toUnmodifiableList());
    }
}
