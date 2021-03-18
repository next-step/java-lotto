package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final Integer[] LOTTO_NUMBERS = {1,2,3,4,5,6,7,8,9,10,
                                                11,12,13,14,15,16,17,18,19,20,
                                                21,22,23,24,25,26,27,28,29,30,
                                                31,32,33,34,35,36,37,38,39,40,
                                                41,42,43,44,45};

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = createLottoTicket();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> createLottoTicket() {
        List<Integer> numbers = createLottoNumbers();

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                        .limit(LottoConstant.LOTTO_NUMBER_COUNT)
                        .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    private List<Integer> createLottoNumbers() {
        return Arrays.asList(LOTTO_NUMBERS);
    }

    public List<Integer> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
