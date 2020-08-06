package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketGenerator {
    private static final int LOTTERY_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNTS = 6;
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream
            .rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private LottoTicketGenerator() {}

    public static LottoTicket purchaseGoodLuck(int amount) {
        int lottoCount = amount / LOTTERY_PRICE;
        return new LottoTicket(
                makeLottos(lottoCount),
                makePrice(lottoCount));
    }

    private static List<Lotto> makeLottos(int count) {
        return Stream.generate(LottoTicketGenerator::generateNumbers)
                .limit(count)
                .collect(Collectors.toList());
    }

    private static int makePrice(int count) {
        return count * LOTTERY_PRICE;
    }

    private static Lotto generateNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS
                .stream()
                .limit(LOTTO_NUMBER_COUNTS)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Lotto::new));
    }
}
