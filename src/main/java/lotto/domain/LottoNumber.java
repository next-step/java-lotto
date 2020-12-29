package lotto.domain;

import util.CommonConstants;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class LottoNumber {
    private Set<Number> numberRange = new HashSet<>();

    public LottoNumber() {
        lottoNumberRangeCreate();
    }

    private void lottoNumberRangeCreate() {
       IntStream.rangeClosed(CommonConstants.LOTTO_NUMBER_MIN, CommonConstants.LOTTO_NUMBER_MAX)
                .boxed().forEach(s -> numberRange.add(new Number(s)));
    }

    public int numberRangeSize() {
        return numberRange.size();
    }

}
