package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int SIZE = 6;

    private static Integer BOUND_START = 1;

    private static Integer BOUND_END = 45;

    public static final List<Number> BOUND_NUMBERS = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .mapToObj(i -> new Number(i))
            .collect(Collectors.toList());

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
                .filter(number -> winningNumbers.checkContainNumber(number))
                .count();
        return count.intValue();
    }

    public boolean checkContainNumber(Number number) {
        return lottoNumbers.contains(number);
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }
}
