package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int SIZE = 6;

    private final List<Number> lottoNumbers;

    public Lotto(GetLottoNumbersStrategy getLottoNumbersStrategy) {
        List<Number> lottoNumbers = getLottoNumbersStrategy.getLotto();
        checkSize(lottoNumbers);
        checkDistinct(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize(List<Number> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

    private void checkDistinct(List<Number> lottoNumbers) {
        Integer compareSize = lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
        if (compareSize != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public Integer checkMatching(WinningNumbers winningNumbers) {
        Long count = lottoNumbers.stream()
                .filter(winningNumbers::checkContainNumber)
                .count();
        return count.intValue();
    }

    public boolean checkContainNumber(BonusBall bonusBall) {
        return lottoNumbers.contains(bonusBall.getBonusBall());
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
