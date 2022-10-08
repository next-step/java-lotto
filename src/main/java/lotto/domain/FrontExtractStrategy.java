package lotto.domain;

import java.util.List;

public class FrontExtractStrategy extends ExtractStrategy {

    @Override
    public List<Integer> extractNumber(int number) {
        return baseNumbers.subList(0, number);
    }
}
