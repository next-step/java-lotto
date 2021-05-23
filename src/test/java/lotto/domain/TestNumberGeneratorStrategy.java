package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class TestNumberGeneratorStrategy implements NumberGeneratorStrategy {
    @Override
    public List<String> generator() {
        return Arrays.asList("1", "2", "3", "4", "5", "6");
    }
}
