package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.number.LottoNumber.FIRST_NUMBER;
import static lotto.domain.number.LottoNumber.LAST_NUMBER;
import static lotto.domain.ticket.LottoTicket.SIZE_OF_LOTTO;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<Integer> CANDIDATES;

    static {
        CANDIDATES = new ArrayList<>();
        for (int number = FIRST_NUMBER; number <= LAST_NUMBER; number++) {
            CANDIDATES.add(number);
        }
    }

    @Override
    public List<Integer> create() {
        List<Integer> candidates = new ArrayList<>(CANDIDATES);
        Collections.shuffle(candidates);
        return candidates.subList(0, SIZE_OF_LOTTO);
    }

}
