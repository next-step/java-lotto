package lottery.domain.factory;

import lottery.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoTicketsDispenser {

    public static LottoTickets dispense(Money money,
                                        List<String> manualNumbersStrings){
        ManualTickets manualTickets = manualPickDispense(manualNumbersStrings);
        money.decrease(manualNumbersStrings.size() * LottoTicket.PRICE);
        QuickTickets quickTickets = quickPickDispense(money);
        return new LottoTickets(manualTickets, quickTickets);
    }

    private static ManualTickets manualPickDispense(List<String> manualNumbersStrings) {
        if (Objects.isNull(manualNumbersStrings))
            return new ManualTickets(Collections.emptyList());
        return new ManualTickets(manualNumbersStrings.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
    }

    private static QuickTickets quickPickDispense(Money money) {
        if (money.isZero())
            return new QuickTickets(Collections.emptyList());
        return new QuickTickets(LongStream.range(0, money.amount() / LottoTicket.PRICE)
                .mapToObj(count -> new LottoTicket())
                .collect(Collectors.toUnmodifiableList()));
    }

}
