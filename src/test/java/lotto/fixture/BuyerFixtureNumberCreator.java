package lotto.fixture;

import lotto.model.dto.LottoNumber;
import lotto.util.NumbersCreator;

import java.util.List;

public class BuyerFixtureNumberCreator implements NumbersCreator {
    private final List<List<LottoNumber>> numbersCreators;
    private int current;

    public static BuyerFixtureNumberCreator of(List<List<LottoNumber>> numbersCreators) {
        return new BuyerFixtureNumberCreator(numbersCreators);
    }

    public BuyerFixtureNumberCreator(List<List<LottoNumber>> numbersCreators) {
        this.numbersCreators = numbersCreators;
        this.current = 0;
    }

    @Override
    public List<LottoNumber> create() {
        if (current < numbersCreators.size()) {
            return numbersCreators.get(current++);
        }
        throw new IndexOutOfBoundsException("할당된 fixtures 보다 더 많은 숫자들을 생성할수 없습니다.");
    }
}
