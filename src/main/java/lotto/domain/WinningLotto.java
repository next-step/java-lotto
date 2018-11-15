package lotto.domain;

import lotto.utils.LottoCollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<LottoNo> numbers;
    private LottoNo bonusNumber;

    private WinningLotto(List<LottoNo> numbers, LottoNo bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<LottoNo> numbers, LottoNo bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(numbers.stream().map(LottoNo::create).collect(Collectors.toList()), null);
    }

    public List<LottoNo> getNumbers(){
        return this.numbers;
    }

    public List<LottoNo> getNumbersWithBonus(){
        return LottoCollectionUtils.merge(this.numbers, this.bonusNumber);
    }
}
