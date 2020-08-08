package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketGenerator {
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream
            .rangeClosed(LottoGameRule.getLottoNumberMin(), LottoGameRule.getLottoNumberMax())
            .boxed()
            .collect(Collectors.toList());

    private LottoTicketGenerator() {}

    public static LottoTicket purchaseGoodLuck(int amount) {
        int lottoCount = amount / LottoGameRule.getLottoPrice();
        return Stream.generate(LottoTicketGenerator::generateNumbers)
                .limit(lottoCount)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
    }

    private static Lotto generateNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS
                .stream()
                .limit(LottoGameRule.getLottoCount())
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Lotto::new));
    }
}
