package lotto.domain;

import java.util.*;

public class AutoLottoTicketGenerator implements TicketGenerator {

    private static AutoLottoTicketGenerator autoLottoTicketGenerator = new AutoLottoTicketGenerator();

    private final int NUMBER_COUNT_PER_TICKET = 6;

    private static final List<Integer> numberPool = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numberPool.add(i);
        }
    }

    public static AutoLottoTicketGenerator start() {
        if (autoLottoTicketGenerator == null) {
            autoLottoTicketGenerator = new AutoLottoTicketGenerator();
        }
        return autoLottoTicketGenerator;
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
