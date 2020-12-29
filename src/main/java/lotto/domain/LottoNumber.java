package lotto.domain;

import util.CommonConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumber {
    private List<Number> numberRange = new ArrayList<>();

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

    public List<Number> getNumberRange() {
        return numberRange;
    }
}
