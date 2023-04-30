package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationListFactory implements ListFactory {

    @Override
    public List<Operation> extractToList(String[] splits) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(splits.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> Operation.toOperation(splits[i]))
                .collect(Collectors.toList());
    }
}
