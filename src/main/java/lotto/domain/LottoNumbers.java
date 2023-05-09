package lotto.domain;

import lotto.domain.result.Rank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_SIZE = 6;

    public List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = createLottoNumber();
    }

    public List<Integer> createLottoNumber() {
        List<Integer> collect = Stream.iterate(MIN_LOTTO_NUMBER, n -> n + 1).limit(MAX_LOTTO_NUMBER).collect(Collectors.toList());
        Collections.shuffle(collect);
        List<Integer> subList = new ArrayList<>(collect.subList(0,LOTTO_SIZE));
        Collections.sort(subList);
        ExceptionHandler.validLottoNumberRange(subList);
        return subList;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }

    public int getHitCount(List<Integer> winningLotto) {
        return winningLotto.stream()
                .filter(lottoNumbers::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }
}
