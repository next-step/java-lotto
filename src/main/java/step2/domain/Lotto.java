package step2.domain;

import step2.domain.starategy.GetLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public static final int SIZE = 6;

    private static Integer BOUND_START = 1;

    private static Integer BOUND_END = 45;

    public static final List<Integer> BOUND_NUMBER = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .boxed()
            .collect(Collectors.toList());

    public Lotto(GetLottoNumberStrategy getLottoNumberStrategy) {
        List<Integer> lottoNumbers = getLottoNumberStrategy.getLotto();
        checkSize(lottoNumbers);
        checkDistinct(lottoNumbers);
        this.lottoNumbers = getLottoNumberStrategy.getLotto();
    }

    public void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

    public void checkDistinct(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().collect(Collectors.toList()).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Integer checkMatching(List<Integer> winningNumbers) {
        Long count = lottoNumbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
        return count.intValue();
    }
}
