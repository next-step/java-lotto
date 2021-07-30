package lotto.domain.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;

public class LottoService {

    private static final List<Integer> ALL_NUMBERS = IntStream.range(LottoNumber.BOTTOM_OF_RANGE,
            LottoNumber.TOP_OF_RANGE).boxed().collect(Collectors.toList());

    public static LottoTicket createRandomTicket() {
        Collections.shuffle(ALL_NUMBERS);
        List<Integer> numbers = ALL_NUMBERS.subList(0, LottoTicket.LOTTO_SIZE);
        return LottoTicket.createFromList(numbers);
    }
}
