package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.number.LottoNumber.FIRST_NUMBER;
import static lotto.domain.number.LottoNumber.LAST_NUMBER;
import static lotto.domain.ticket.LottoTicket.SIZE_OF_LOTTO;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final List<Integer> CANDIDATES = IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Integer> create() {
        List<Integer> candidates = new ArrayList<>(CANDIDATES);
        Collections.shuffle(candidates);
        return candidates.subList(0, SIZE_OF_LOTTO);
    }

}
