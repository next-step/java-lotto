package lotto.domain.strategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int NUMBERS_COUNT = 6;

    @Override
    public List<LottoTicket> generate(int quantity) {
        List<LottoTicket> lottoTickets = new LinkedList<>();
        List<LottoNumber> numbers = initNumbers();

        for (int i = 0; i < quantity; i++) {
            // 자동 생성할 때마다 번호를 섞는다.
            Collections.shuffle(numbers);
            lottoTickets.add(new LottoTicket(Set.copyOf(numbers.subList(0, NUMBERS_COUNT))));
        }

        return lottoTickets;
    }

    private List<LottoNumber> initNumbers() {
        return IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
