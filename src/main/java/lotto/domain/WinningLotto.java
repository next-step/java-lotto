package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private final Lotto numbers;
    private final NumberElement bonusNumber;

    public WinningLotto(Integer... numbers) {
        this(integerToLottoNumbers(numbers), new NumberElement());
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this(integerToLottoNumbers(numbers), new NumberElement(bonusNumber));
    }

    public WinningLotto(Lotto numbers, int bonusNumber) {
        this(numbers, new NumberElement(bonusNumber));
    }

    public WinningLotto(Lotto numbers, NumberElement bonusNumber) {
        numbers.validateOverlapBonusNumber(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoNumber(BuyLotto buyLottos) {
        return buyLottos.match(this);
    }

    private static Lotto integerToLottoNumbers(Integer... numbers) {
        return new Lotto(Arrays.stream(numbers)
                .map(NumberElement::new)
                .toList());
    }

    private static Lotto integerToLottoNumbers(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(NumberElement::new)
                .toList());
    }

    public LottoRank matchCount(Lotto buyLotto) {
        int count = buyLotto.matchCount(this.numbers);

        if (isBonus(count)) {
            return checkBonusNumber(buyLotto, bonusNumber);
        }

        return LottoRank.fromMatchCount(count);
    }

    private static boolean isBonus(int count) {
        return count == 5;
    }

    public LottoRank checkBonusNumber(Lotto buyLotto, NumberElement bonusNumber) {
        if (buyLotto.checkBonusNumber(bonusNumber)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
