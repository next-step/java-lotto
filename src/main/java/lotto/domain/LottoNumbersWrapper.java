package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersWrapper {
    private final List<LottoNo> numbers;

    public LottoNumbersWrapper(List<Integer> numbers) {
        this.numbers = numbers
                .stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        List<Integer> collect = numbers.stream()
                .map(LottoNo::getLottoNumber)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(collect);
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
