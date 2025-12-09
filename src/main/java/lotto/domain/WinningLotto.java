package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto numbers;
    private final NumberElement bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this(integerToLottoNumbers(numbers), NumberElement.create(bonusNumber));
    }

    public WinningLotto(Lotto numbers, int bonusNumber) {
        this(numbers, NumberElement.create(bonusNumber));
    }

    public WinningLotto(Lotto numbers, NumberElement bonusNumber) {
        numbers.validateOverlapBonusNumber(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoNumber(PurchasedLottos purchasedLottos) {
        return purchasedLottos.match(this);
    }

    private static Lotto integerToLottoNumbers(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(NumberElement::create)
                .collect(Collectors.toSet()));
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

    public LottoRank checkBonusNumber(Lotto purchasedLotto, NumberElement bonusNumber) {
        if (purchasedLotto.checkBonusNumber(bonusNumber)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
