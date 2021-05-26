package lotto.domain;

import java.util.*;

public class LottoTicketGenerator implements TicketGenerator {

    private static LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    private final int NUMBER_COUNT_PER_TICKET = 6;

    private static final List<Integer> numberPool = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numberPool.add(i);
        }
    }

    public static LottoTicketGenerator start() {
        if (lottoTicketGenerator == null) {
            lottoTicketGenerator = new LottoTicketGenerator();
        }
        return lottoTicketGenerator;
    }


    @Override
    public LottoTicket extract() {
        Collections.shuffle(numberPool);
        List<Integer> extracted = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT_PER_TICKET; i++) {
            extracted.add(numberPool.get(i));
        }
        Collections.sort(extracted);
        return new LottoTicket(extracted);
    }
}
