package lotto.domain;


import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoTickets {

    private static final int START_INDEX = 0;
    private final List<LottoNumbers> lottoNumbers;
    private final List<Integer> generateNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoTickets(Money money) {
        this.lottoNumbers = buyLotto(money);
    }

    public static LottoTickets of(long money) {
        return new LottoTickets(Money.of(money));
    }

    public List<LottoNumbers> getLottoTickets() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private List<LottoNumbers> buyLotto(Money money) {
        long size = money.lottoTicketCount();
        List<LottoNumbers> numbers = new ArrayList<>();
        LongStream.range(START_INDEX, size)
                .forEach((s) -> numbers.add(generateLottoNumbers()));

        return numbers;
    }

    private LottoNumbers generateLottoNumbers() {
        Collections.shuffle(generateNumbers);
        List<Integer> numbers = generateNumbers.subList(START_INDEX, LottoNumber.LOTTO_NUMBER_SIZE);
        Collections.sort(numbers);

        return new LottoNumbers(numbers);
    }
}
