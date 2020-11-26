package humbledude.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    public static final long LOTTO_TICKET_PRICE = 1000;

    public LottoStore() {}

    public static List<LottoNumbers> buyAutoTickets(Budget budget) {
        long howMany = budget.getAmountOfAutoLottos();

        return LongStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());
    }


}
