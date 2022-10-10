package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersWrapper {
    private final List<LottoNo> numbers;

    public LottoNumbersWrapper(List<Integer> numbers) {
        this.numbers = numbers
                .stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNo::getLottoNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean contains(Integer number) {
        return this.getNumbers().contains(number);
    }

    public int getMatchCount(LottoNumbersWrapper collectNumberList) {
        int matchCount = 0;
        for (LottoNo lottoNo : this.numbers) {
            matchCount += getMatchCount(collectNumberList, lottoNo.getLottoNumber());
        }
        return matchCount;
    }

    public boolean isMatchToBonusNumber(int bonusNumber) {
        return this.getNumbers().contains(bonusNumber);
    }

    private int getMatchCount(LottoNumbersWrapper lottoNumbersWrapper, int number) {
        if (lottoNumbersWrapper.contains(number)) {
            return 1;
        }
        return 0;
    }
}
