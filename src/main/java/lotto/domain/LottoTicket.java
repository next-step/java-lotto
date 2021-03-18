package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 45)
                                                            .boxed()
                                                            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = createLottoTicket();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> createLottoTicket() {
        List<Integer> numbers = LOTTO_NUMBERS;

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                        .limit(LottoConstant.LOTTO_NUMBER_COUNT)
                        .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    public List<Integer> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
