package lotto.domain;

import util.CommonConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, Number> lottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(CommonConstants.LOTTO_NUMBER_MIN, CommonConstants.LOTTO_NUMBER_MAX)
                .boxed().forEach(index -> {
                    lottoNumbers.put(index, new Number(index));
        });
    }

    public static List<Number> collectionLottoNumbers() {
        return new ArrayList<>(lottoNumbers.values());
    }

    public static Number of(int number) {
        return lottoNumbers.get(number);
    }

    public int numberRangeSize() {
        return lottoNumbers.size();
    }
}
