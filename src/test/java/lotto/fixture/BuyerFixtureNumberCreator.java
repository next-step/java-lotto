package lotto.fixture;

import lotto.util.NumbersCreator;

import java.util.List;

public class BuyerFixtureNumberCreator implements NumbersCreator {
    private final List<Integer[]> numbersCreatorResults;
    private int current;

    public static BuyerFixtureNumberCreator of(List<Integer[]> numbersCreatorResults) {
        return new BuyerFixtureNumberCreator(numbersCreatorResults);
    }

    public BuyerFixtureNumberCreator(List<Integer[]> numbersCreatorResults) {
        this.numbersCreatorResults = numbersCreatorResults;
        this.current = 0;
    }

    @Override
    public Integer[] create() {
        return numbersCreatorResults.get(current++);
    }
}
