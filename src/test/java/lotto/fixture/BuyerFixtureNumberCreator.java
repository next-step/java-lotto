package lotto.fixture;

import lotto.util.NumbersCreator;

import java.util.List;

public class BuyerFixtureNumberCreator implements NumbersCreator {
    private final List<Integer[]> numbersCreators;
    private int current;

    public static BuyerFixtureNumberCreator of(List<Integer[]> numbersCreators) {
        return new BuyerFixtureNumberCreator(numbersCreators);
    }

    public BuyerFixtureNumberCreator(List<Integer[]> numbersCreators) {
        this.numbersCreators = numbersCreators;
        this.current = 0;
    }

    @Override
    public Integer[] create() {
        if (current < numbersCreators.size()) {
            return numbersCreators.get(current++);
        }
        throw new IndexOutOfBoundsException("할당된 fixtures 보다 더 많은 숫자들을 생성할수 없습니다.");
    }
}
