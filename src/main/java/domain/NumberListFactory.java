package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberListFactory implements ListFactory {

    @Override
    public List<Integer> extractToList(String[] splits) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(splits.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(splits[i]))
                .collect(Collectors.toList());
    }
}
