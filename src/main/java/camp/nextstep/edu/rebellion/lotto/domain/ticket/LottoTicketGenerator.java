package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketGenerator {

    private LottoTicketGenerator() {}

    public static LottoTicket purchaseGoodLuck(int amount) {
        int lottoCount = amount / LottoGameRule.getLottoPrice();

        return Stream.generate(LottoTicketGenerator::generateNumbers)
                .limit(lottoCount)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        LottoTicket::new));
    }

    private static Lotto generateNumbers() {
        return LottoNumberDice.roll()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Lotto::new));
    }
}
