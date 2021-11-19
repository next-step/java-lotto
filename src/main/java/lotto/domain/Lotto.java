package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int SIZE = 6;

    private static Integer BOUND_START = 1;

    private static Integer BOUND_END = 45;

    public static final List<Integer> BOUND_NUMBERS = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public Lotto(GetLottoNumbersStrategy getLottoNumbersStrategy) {
        List<Integer> lottoNumbers = getLottoNumbersStrategy.getLotto();
        checkSize(lottoNumbers);
        checkDistinct(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

    private void checkDistinct(List<Integer> lottoNumbers) {
        Integer compareSize = lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
        if (compareSize != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public Integer checkMatching(List<Integer> winningNumbers) {
        Long count = lottoNumbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
        return count.intValue();
    }
}
