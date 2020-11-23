package humbledude.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    public static final long LOTTO_TICKET_PRICE = 1000;

    public LottoStore() {}

    public static List<LottoNumberSet> buyAutoTickets(long budget) {
        long howMany = howManyCanIBuy(budget);

        return LongStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());
    }

    public static long howManyCanIBuy(long budget) {
        return budget / LOTTO_TICKET_PRICE;
    }

}
