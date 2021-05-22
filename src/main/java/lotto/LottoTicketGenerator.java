package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {

    private static LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int NUMBER_COUNT_PER_TICKET = 6;

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
            pool.add(new LottoNumber(num));
        }
        return pool;
    }

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
