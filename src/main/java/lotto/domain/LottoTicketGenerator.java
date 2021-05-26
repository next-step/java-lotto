package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator implements TicketGenerator {

    private static LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 45;
    private final int NUMBER_COUNT_PER_TICKET = 6;

    private final List<LottoNumber> numberPool;

    private LottoTicketGenerator() {
        numberPool = createNumberPool();
    }

    public static LottoTicketGenerator start() {
        if (lottoTicketGenerator == null) {
            lottoTicketGenerator = new LottoTicketGenerator();
        }
        return lottoTicketGenerator;
    }

    private List<LottoNumber> createNumberPool() {
        List<LottoNumber> pool = new ArrayList<>();
        for (int num = MIN_VALUE; num <= MAX_VALUE; num++) {
            pool.add(LottoNumber.of(num));
        }
        return pool;
    }

    @Override
    public LottoTicket extract() {
        Collections.shuffle(numberPool);
        List<LottoNumber> extracted = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT_PER_TICKET; i++) {
            extracted.add(numberPool.get(i));
        }
        Collections.sort(extracted);
        return new LottoTicket(extracted);
    }
}
