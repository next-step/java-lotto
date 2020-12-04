package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.NUMBER_MAX_RANGE;
import static lotto.domain.LottoNumber.NUMBER_MIN_RANGE;
import static lotto.domain.LottoNumbers.NUMBER_RANGE;

public class CachedLottoNumbers {
    private final Map<Integer, LottoNumber> lottoNumbers;

    public CachedLottoNumbers() {
        lottoNumbers = IntStream.range(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toMap(LottoNumber::getValue, lottoNumber -> lottoNumber));
    }

    public LottoNumber getLottoNumber(int number){
        return lottoNumbers.get(number);
    }

    public List<LottoNumbers> getLottoNumbers(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(index -> new LottoNumbers(pickLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> pickLottoNumbers() {
        List<LottoNumber> lottoNumbers = convertToList();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .limit(NUMBER_RANGE)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

    }

    private List<LottoNumber> convertToList() {
        return new ArrayList<>(lottoNumbers.values());
    }
}
