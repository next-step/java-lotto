package lottery.domain.strategy;

import lottery.domain.LotteryNumber;

import java.util.*;
import java.util.stream.Collectors;

public class StaticPicker implements Picker {
    private static final String DELIMITER = " *, *";

    private final Iterator<String> iterator;

    public StaticPicker(String input) {
        this.iterator = Collections.singletonList(input).iterator();
    }

    public StaticPicker(List<String> inputs) {
        this.iterator = new ArrayList<>(inputs).iterator();
    }
    
    @Override
    public List<LotteryNumber> pick(int count) {
        String[] numbers = iterator.next().split(DELIMITER);
        return Arrays.stream(numbers)
                .map(LotteryNumber::valueOf)
                .collect(Collectors.toList());
    }
}
