package domain.extractor;

import common.error.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperandExtractor implements Extractor<List<Integer>> {

    private static final int EVEN_REMAIN_RESULT = 0;
    private static final int INDEX_DIVIDE_NUMBER = 2;
    private static final int INITIAL_INDEX = 0;

    @Override
    public List<Integer> extract(List<String> inputList) {

        return IntStream.range(INITIAL_INDEX, inputList.size())
                .filter(this::isEvent)
                .mapToObj(index -> toOperator(index, inputList))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isEvent(int index) {
        return index % INDEX_DIVIDE_NUMBER == EVEN_REMAIN_RESULT;
    }

    private int toOperator(int index, List<String> inputList) {
        String input = inputList.get(index);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NO_SUCH_OPERAND.getErrorMessage());
        }
    }

}
