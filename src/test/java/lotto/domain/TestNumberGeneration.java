package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class TestNumberGeneration implements NumberGeneration {
    @Override
    public List<Integer> generate() {
        return Arrays.asList(1,1,1,1,1,1);
    }
}