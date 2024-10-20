package lotto.fixture;

import lotto.model.dto.LottoNumber;
import lotto.util.NumbersCreator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuyerFixtureNumberCreator implements NumbersCreator {
    private final List<List<LottoNumber>> numbersCreators;
    private int current;

    public BuyerFixtureNumberCreator(List<int[]> numbersCreators) {
        this.numbersCreators = numbersCreators.stream()
                .map(ints -> Arrays.stream(ints)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toList());
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
